%====================================================================================
% prod_cons description   
%====================================================================================
dispatch( info, info(N) ). %commento
request( req, requesting(N) ). %formato di richiesta Prod -> Cons
%====================================================================================
context(ctxproducer, "localhost",  "TCP", "8014").
context(ctxconsumer, "130.136.113.239",  "TCP", "8015").
 qactor( consumer, ctxconsumer, "external").
  qactor( producer, ctxproducer, "it.unibo.producer.Producer").
 static(producer).
