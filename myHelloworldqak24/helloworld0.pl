%====================================================================================
% helloworld0 description   
%====================================================================================
dispatch( info, info(N) ). %commento
request( req, requesting(N) ). %formato di richiesta Prod -> Cons
%====================================================================================
context(ctxhello, "localhost",  "TCP", "8000").
 qactor( producer, ctxhello, "it.unibo.producer.Producer").
 static(producer).
  qactor( consumer, ctxhello, "it.unibo.consumer.Consumer").
 static(consumer).
