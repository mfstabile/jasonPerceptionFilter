#
# by Jomi
#

#TARGET = $(shell ls *.tex | cut -f 1 -d ".")

#all: 
#	latex2html -dir ../../jason-jade -mkdir -split 0 -white -image_type=png -nonavigation -noinfo -address "" -math -style ../labs.css $(TARGET)

publish:
	scp index.html jomifred,jason@web.sf.net:/home/groups/j/ja/jason/htdocs/mini-tutorial/eclipse-plugin
	scp -r images jomifred,jason@web.sf.net:/home/groups/j/ja/jason/htdocs/mini-tutorial/eclipse-plugin
