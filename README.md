## Софтуерни технологии 2019

Практически проект

=============================================================

ас. Йордан Тодоров

email: jtodorov@uni-plovdiv.net

хон. ас. Илиян Горки

email: iliqngorki@abv.bg


### Setting up the project at home for Eclipse - OS Windows 64bit

## Download eclipse jee for windows 64bit

https://www.eclipse.org/downloads/packages/release/helios/sr1/eclipse-ide-java-ee-developers
After running the installation select Eclipse for Enterprise development (probably the second choice)

## Cloning the project

Open eclipse and select Window -> Perspective -> Other Perspective -> Other -> Git

On the left should be a panel Git Repositories (if there is no such a panel go to Window -> Perspective -> Reset Perspective)

Select - Clone a Git repository

Paste the following git link in URI:

https://github.com/pepo-malinov/ST-546-Malinov-Petrov.git

Next -> Next -> Finish

Go to Window -> Perspective -> Other perspective -> Web  (or use the shortcut on the right next to git shortcut)

On the right there should be the cloned project within a panel Project Explorer

(If the panel is not visible go to WIndow -> Perspective -> Reset Perspective)


Go to File -> Open Projects from File System -> Choose directory and navigate to the folder where the project was cloned and select Finish


## Setting up Tomcat server

https://tomcat.apache.org/download-90.cgi

Choose the zip file for Windows 64bit

Download and extract to a folder

Go to eclipse and find the tab servers at the bottom. Select and there will be a link to Create a new server

In the field select the server type: type in tomcat and select tomcat v9.0 server

Choose tomcat installation directory and browse to the extracted tomcat server folder and click Finish

Go to Window -> Preferences -> Java -> Installed JRE-s

There will be one jre file listed. Select and Remove it

Click on Add.. Choose Standard VM (3-rd option)

For JRE home: click on Directory…
and find your jdk it should be within Program Files / java / jdk1.8…. And select the folder

Click on Finish

Make sure that the newly added jdk in the list is checked

    [ ] jdk1.8…..

Click Apply and Close

*If there is no jdk on your computer you need to download a jdk for windows 64bit*

*https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html*


Select the project within the Project explorer. Right click and choose properties

Go to project facets and click on Convert to faceted form…

Mark the options:

    [ ] Dynamic web module

    [ ] Java

    [ ] Javascript

Click on  Dynamic web module

There will be a tab on the right “runtimes” select tomcat

Apply and Close

Right click on the project within the Project explorer panel then  > Run as > Run on server and press Finish

*If there is a problem connected with port in use go to the Tab servers at the bottom and double click on Tomcat v9.0 server
On the right there will be a Port Number for HTTP/1.1 which by default is 8080
Enter 8181 or 8888 save and try to rerun the project on the server*


=============================================================


### ЗАДАНИЕ ПРАКТИКУМ МАГИСТРИ 2019/2020

За получаване на оценка по дисциплина „Практукум“ студентите трябва да подготвят
проект изпълнявайки следните задачи:

    * Намирате (или изграждате свое) API което да връща някаква информация.

    * Изграждате HTML страница съдържаща форма с полета които се използват за изпращане на заявка към API-то което сте намерили в т.1. Точния вид на формата и нейните полета определяте вие, но задължително да има начин за определяне точно на каква информация да бъде върната от външния сървис(това може да стане с <select> или radio buttons или checkboxes). Например: Намерил съм API което връща информация за филми и съответно съм направил форма която да има поле за търсене на филм по име, а от долу ще сложа няколко checkbox-а които ще определят каква информация искам (заглавие на филм, описание, обложка, артисти, жарн и тн).

    * При натискане на бутона за submit на формата се изпраща ajax заявка към сървиса и върната информация се визуализира във пространството под формата. При натискане на бутон отново се прави нова заявка и новата информация се прикрепя към вече съществуващата. Информацията се губи само при презареждане на страницата.

    * Над или отстрани на полето където се визуализира информацията да има бутон или бутони позволяващо промяната на дизайна под който се показва информацията. Например: Ако информацията която получавам се визуализира под формата на квадратчета с обложка и информация под нея при натискане на бутончето то същата информация да се визуализира под формата на редове или друг начин(погледнете примерните фигури на края на файла). За разработката на проекта използвайте

### HTML

### CSS

### JavaScript

### Bootstrap

### JQuery

### Ajax


Предаването на проекта трябва да се извърши лично до 08.12.2019г. Проекта е предвиден за самостоятелна работа, съответно всички предаващи проекти ще бъдат препитани относно функционалностите и работата на проекта
