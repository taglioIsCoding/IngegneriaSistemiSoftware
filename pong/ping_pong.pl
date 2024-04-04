%====================================================================================
% ping_pong description   
%====================================================================================
dispatch( ball, ball(NUM_GAME) ). %Dispactch che rappresenta il colpo di racchetta
dispatch( update, update(STR,N) ). %Dispactch che rappresenta il colpo di racchetta
request( info_test, info_test(X) ). %sent by the testUnit to the observer
%====================================================================================
context(ctxping, "127.0.0.1",  "TCP", "8000").
context(ctxpong, "localhost",  "TCP", "8001").
 qactor( ping, ctxping, "external").
  qactor( pong, ctxpong, "it.unibo.pong.Pong").
 static(pong).
