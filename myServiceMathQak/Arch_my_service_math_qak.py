### conda install diagrams
from diagrams import Cluster, Diagram, Edge
from diagrams.custom import Custom
import os
os.environ['PATH'] += os.pathsep + 'C:/Program Files/Graphviz/bin/'

graphattr = {     #https://www.graphviz.org/doc/info/attrs.html
    'fontsize': '22',
}

nodeattr = {   
    'fontsize': '22',
    'bgcolor': 'lightyellow'
}

eventedgeattr = {
    'color': 'red',
    'style': 'dotted'
}
with Diagram('my_service_math_qakArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxserver', graph_attr=nodeattr):
          server=Custom('server','./qakicons/symActorSmall.png')
          runner=Custom('runner','./qakicons/symActorSmall.png')
          client=Custom('client','./qakicons/symActorSmall.png')
          asyncclient=Custom('asyncclient','./qakicons/symActorSmall.png')
     server >> Edge(color='magenta', style='dotted', decorate='true', label='<currentMsg &nbsp; >',  fontcolor='green') >> runner
     client >> Edge(color='magenta', style='solid', decorate='true', label='<fibo_request &nbsp; >',  fontcolor='magenta') >> server
     runner >> Edge(color='blue', style='solid',  decorate='true', label='<fibo_dispatch &nbsp; >',  fontcolor='blue') >> asyncclient
     asyncclient >> Edge(color='blue', style='solid',  decorate='true', label='<fibo_dispatch &nbsp; >',  fontcolor='blue') >> server
diag
