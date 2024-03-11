import socket

HOST = "127.0.0.1"  # The server's hostname or IP address
PORT = 8011  # The port used by the server
request = "msg(distance,request,pippo,mtagliani,50,3)\n"
dispatch = "msg(distance,dispatch,pippo,mtagliani,50,3)\n"

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))
    data = str.encode(request)
    s.sendall(data)
    data = s.recv(8)

    while not data.endswith(b'\n'):
        data += s.recv(8)
    
print(f"Received Responce: {data}")

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))
    data = str.encode(dispatch)
    s.sendall(data)