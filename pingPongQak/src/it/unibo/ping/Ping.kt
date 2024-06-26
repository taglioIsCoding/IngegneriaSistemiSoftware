/* Generated by AN DISI Unibo */ 
package it.unibo.ping

import it.unibo.kactor.*
import alice.tuprolog.*
import unibo.basicomm23.*
import unibo.basicomm23.interfaces.*
import unibo.basicomm23.utils.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import it.unibo.kactor.sysUtil.createActor   //Sept2023

//User imports JAN2024

class Ping ( name: String, scope: CoroutineScope, isconfined: Boolean=false  ) : ActorBasicFsm( name, scope, confined=isconfined ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		//val interruptedStateTransitions = mutableListOf<Transition>()
		 var X = 20  
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						CommUtils.outmagenta("Sono il $name")
						Thread.sleep(200) 
						CommUtils.outmagenta("$name: sending ping ...")
						forward("hit", "hit($X)" ,"pong" ) 
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t00",targetState="handleEnemyHit",cond=whenDispatch("hit"))
				}	 
				state("handleEnemyHit") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("hit(NUM_GAME)"), Term.createTerm("hit(NUM_GAME)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								CommUtils.outmagenta("$name: recived pong ${payloadArg(0)}")
								if( (0..10).random() % 4 != 0 
								 ){CommUtils.outmagenta("$name: I hit the ball =)")
								 X = X + 1  
								forward("hit", "hit($X)" ,"pong" ) 
								}
								else
								 {CommUtils.outmagenta("$name: I miss the ball =(")
								 }
						}
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t01",targetState="handleEnemyHit",cond=whenDispatch("hit"))
				}	 
			}
		}
} 
