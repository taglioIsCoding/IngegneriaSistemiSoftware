/* Generated by AN DISI Unibo */ 
package it.unibo.referee

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

class Referee ( name: String, scope: CoroutineScope, isconfined: Boolean=false  ) : ActorBasicFsm( name, scope, confined=isconfined ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		//val interruptedStateTransitions = mutableListOf<Transition>()
		
				var Nlast = ""
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						CommUtils.outblue("	Sono il $name")
						observeResource("127.0.0.1","8000","ctxping","ping","update")
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="recive_update0",targetState="handle_update",cond=whenDispatch("update"))
				}	 
				state("handle_update") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("update(STR,N)"), Term.createTerm("update(STR,N)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								 
												if ( payloadArg(1) != "nonews")
													Nlast = payloadArg(1) 
								CommUtils.outblue("$name: saw ${payloadArg(0)} with ${payloadArg(1)}")
						}
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="recive_update1",targetState="handle_update",cond=whenDispatch("update"))
					transition(edgeName="recive_update2",targetState="handle_test_req",cond=whenRequest("info_test"))
				}	 
				state("handle_test_req") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("info_test(X)"), Term.createTerm("info_test(X)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								answer("info_test", "info_test", "obsinfo($Nlast)"   )  
						}
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
				}	 
			}
		}
} 
