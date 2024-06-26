/* Generated by AN DISI Unibo */ 
package it.unibo.sonar

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

class Sonar ( name: String, scope: CoroutineScope, isconfined: Boolean=false  ) : ActorBasicFsm( name, scope, confined=isconfined ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		//val interruptedStateTransitions = mutableListOf<Transition>()
		
				var isSonarOn = false
				var ledBlue = true	
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						CommUtils.outmagenta("Sono il $name")
						delay(500) 
						observeResource("localhost","8000","wolfdetectionlocal","sensor","update")
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t14",targetState="handle_sonar",cond=whenRequest("manage_sonar"))
					transition(edgeName="t15",targetState="handle_update",cond=whenDispatch("update"))
				}	 
				state("handle_sonar") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("manage_sonar(STARTSTOP)"), Term.createTerm("manage_sonar(STARTSTOP)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								CommUtils.outmagenta("$name: recived manage_sonar ${payloadArg(0)}")
								 isSonarOn = payloadArg(0).toBoolean()  
								answer("manage_sonar", "manage_sonar", "success(true)"   )  
						}
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t16",targetState="handle_sonar",cond=whenRequest("manage_sonar"))
					transition(edgeName="t17",targetState="handle_update",cond=whenDispatch("update"))
				}	 
				state("handle_update") { //this:State
					action { //it:State
						CommUtils.outmagenta("Rilevato qualcosa dal sensore")
						if( checkMsgContent( Term.createTerm("update(N)"), Term.createTerm("update(N)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								ledBlue = true  
								if(  (0..100).random() % 3 == 0  
								 ){CommUtils.outmagenta("LUPO")
								forward("manage_red_led", "accendi(true)" ,"stazione" ) 
								}
								else
								 {CommUtils.outmagenta("NO LUPO")
								 }
						}
						if( checkMsgContent( Term.createTerm("update(N)"), Term.createTerm("far(N)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								CommUtils.outmagenta("ostacolo lontano")
								ledBlue = false  
								forward("manage_red_led", "accendi(false)" ,"stazione" ) 
						}
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="t18",targetState="handle_sonar",cond=whenRequest("manage_sonar"))
					transition(edgeName="t19",targetState="handle_update",cond=whenDispatch("update"))
				}	 
			}
		}
} 
