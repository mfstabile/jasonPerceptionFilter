TARGET  = faq

html: $(TARGET).tex Makefile
	latex2html  -split 0 -style faq.css \
              -white -image_type=gif -transparent \
              -dir html -mkdir -ascii_mode \
              -address "" -show_section_numbers -noinfo -html_version 3.2,math -no_math \
              -math -no_navigation $(TARGET).tex
	cp faq.css html
	cp html/faq.html ..
	cp faq.css ..

clean:
	rm -f $(TARGET).ps *.log $(TARGET).aux $(TARGET).out || true
	rm -rf auto || true
	rm -rf *pdf || true
	find . -name *bak -exec rm {} \; || true
	find . -name *~ -exec rm {} \; || true

publish:
	scp html/*.html jomifred,jason@web.sf.net:/home/groups/j/ja/jason/htdocs/faq
