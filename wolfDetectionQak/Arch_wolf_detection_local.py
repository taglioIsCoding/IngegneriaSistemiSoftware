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
with Diagram('wolf_detection_localArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('wolfdetectionlocal', graph_attr=nodeattr):
          stazione=Custom('stazione','./qakicons/symActorSmall.png')
          sonar=Custom('sonar','./qakicons/symActorSmall.png')
          sensor=Custom('sensor','./qakicons/symActorSmall.png')
     stazione >> Edge(color='magenta', style='solid', decorate='true', label='<manage_sonar &nbsp; >',  fontcolor='magenta') >> sonar
     sensor >> Edge(color='blue', style='solid',  decorate='true', label='<update &nbsp; >',  fontcolor='blue') >> sonar
     sonar >> Edge(color='blue', style='solid',  decorate='true', label='<manage_red_led &nbsp; >',  fontcolor='blue') >> stazione
diag
