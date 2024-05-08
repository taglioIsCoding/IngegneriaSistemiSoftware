%====================================================================================
% robot_cleaner description   
%====================================================================================
%====================================================================================
context(ctxrobot, "localhost",  "TCP", "8000").
 qactor( robot, ctxrobot, "it.unibo.robot.Robot").
 static(robot).
  qactor( user, ctxrobot, "it.unibo.user.User").
 static(user).
