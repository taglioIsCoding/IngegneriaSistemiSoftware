%====================================================================================
% ping_pong description   
%====================================================================================
dispatch( update, update(STR,N) ).
dispatch( update, nonews(X) ).
request( info_test, info_test(X) ). %sent by the testUnit to the observer
%====================================================================================
context(referee, "localhost",  "TCP", "8002").
context(ctxping, "127.0.0.1",  "TCP", "8000").
 qactor( ping, ctxping, "external").
  qactor( referee, referee, "it.unibo.referee.Referee").
 static(referee).
