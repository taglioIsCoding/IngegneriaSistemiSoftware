/* Generated by AN DISI Unibo */ 
package it.unibo.server

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

class Server ( name: String, scope: CoroutineScope, isconfined: Boolean=false  ) : ActorBasicFsm( name, scope, confined=isconfined ){

	override fun getInitialState() : String{
		return "s0"
	}
	override fun getBody() : (ActorBasicFsm.() -> Unit){
		//val interruptedStateTransitions = mutableListOf<Transition>()
		
				fun fibonacciUsingRecursion(num: Int): Int {
				    return if (num <= 1) {
				        num
				    } else {
				        fibonacciUsingRecursion(num - 1) + fibonacciUsingRecursion(num - 2)
				    }
				}
		return { //this:ActionBasciFsm
				state("s0") { //this:State
					action { //it:State
						CommUtils.outmagenta("Sono il $name")
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="handle0",targetState="handle_request",cond=whenRequest("fibo_request"))
					transition(edgeName="handle1",targetState="handle_dispatch",cond=whenDispatch("fibo_dispatch"))
				}	 
				state("handle_request") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("fibo(X)"), Term.createTerm("fibo(X)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								 val Fibvalue =  fibonacciUsingRecursion(payloadArg(0).toInt())  
								answer("fibo_request", "fibo_reply", "fibo($Fibvalue)"   )  
						}
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="handle2",targetState="handle_request",cond=whenRequest("fibo_request"))
					transition(edgeName="handle3",targetState="handle_dispatch",cond=whenDispatch("fibo_dispatch"))
				}	 
				state("handle_dispatch") { //this:State
					action { //it:State
						if( checkMsgContent( Term.createTerm("fibo(X)"), Term.createTerm("fibo(X)"), 
						                        currentMsg.msgContent()) ) { //set msgArgList
								delegateCurrentMsgTodynamic("runner") 
						}
						//genTimer( actor, state )
					}
					//After Lenzi Aug2002
					sysaction { //it:State
					}	 	 
					 transition(edgeName="handle4",targetState="handle_request",cond=whenRequest("fibo_request"))
					transition(edgeName="handle5",targetState="handle_dispatch",cond=whenDispatch("fibo_dispatch"))
				}	 
			}
		}
} 
