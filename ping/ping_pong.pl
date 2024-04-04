%====================================================================================
% ping_pong description   
%====================================================================================
dispatch( ball, ball(NUM_GAME) ). %Dispactch che rappresenta il colpo di racchetta
dispatch( update, update(STR,N) ). %Dispactch che rappresenta il colpo di racchetta
request( info_test, info_test(X) ). %sent by the testUnit to the observer
%====================================================================================
context(ctxpong, "127.0.0.1",  "TCP", "8001").
context(ctxping, "localhost",  "TCP", "8000").
 qactor( pong, ctxpong, "external").
  qactor( ping, ctxping, "it.unibo.ping.Ping").
 static(ping).
