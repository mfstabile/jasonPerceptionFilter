#
# by Jomi
#

TARGET = $(shell ls *.tex | cut -f 1 -d ".")

all: 
	latex2html -dir ../../jason-jade -mkdir -split 0 -white -image_type=png -nonavigation -noinfo -address "" -math -style ../labs.css $(TARGET)

publish:
	zip -r ../../jason-jade/jade-example.zip jade-example/examples/bookTrading/*.java
	scp ../../jason-jade/* jomifred,jason@web.sf.net:/home/groups/j/ja/jason/htdocs/mini-tutorial/jason-jade
