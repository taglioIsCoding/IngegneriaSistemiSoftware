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
with Diagram('led_qakArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxled', graph_attr=nodeattr):
          led_usage=Custom('led_usage','./qakicons/symActorSmall.png')
          sender=Custom('sender','./qakicons/symActorSmall.png')
     sender >> Edge(color='blue', style='solid',  decorate='true', label='<led_cmd &nbsp; >',  fontcolor='blue') >> led_usage
diag
