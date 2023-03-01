javac -d ./build -cp ./jars/itextpdf-5.5.13.3.jar:jars/pdfbox-app-2.0.27.jar src/*.java
{
  echo "Jan Poonthong"
  echo "janpoonthong@gmail.com"
  echo "911"
  echo "profile.png"
  echo "done"
} | java -cp ./build:./jars/itextpdf-5.5.13.3.jar:jars/pdfbox-app-2.0.27.jar Main
