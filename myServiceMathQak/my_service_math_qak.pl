%====================================================================================
% my_service_math_qak description   
%====================================================================================
request( fibo_request, fibo(X) ).
dispatch( fibo_dispatch, fibo(X) ).
%====================================================================================
context(ctxserver, "localhost",  "TCP", "8000").
 qactor( server, ctxserver, "it.unibo.server.Server").
 static(server).
  qactor( runner, ctxserver, "it.unibo.runner.Runner").
dynamic(runner). %%Oct2023 
  qactor( client, ctxserver, "it.unibo.client.Client").
 static(client).
  qactor( asyncclient, ctxserver, "it.unibo.asyncclient.Asyncclient").
 static(asyncclient).
