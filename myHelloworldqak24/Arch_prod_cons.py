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
with Diagram('prod_consArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxproducer', graph_attr=nodeattr):
          producer=Custom('producer','./qakicons/symActorSmall.png')
     with Cluster('ctxconsumer', graph_attr=nodeattr):
          consumer=Custom('consumer(ext)','./qakicons/externalQActor.png')
     producer >> Edge(color='magenta', style='solid', decorate='true', label='<req &nbsp; >',  fontcolor='magenta') >> consumer
diag
