javac -d ./build -cp ./jars/itextpdf-5.5.13.3.jar:jars/pdfbox-app-2.0.27.jar src/*.java
{
  echo "Jan Poonthong"
  echo "AI Engineer"
  echo "Koh Samui"
  echo "janpoonthong628@gmail.com"
  echo "0987913490"
  echo "https://janpoonthong.github.io/portfolio"
  echo "jan_profile.jpg"
  echo "done"
} | java -cp ./build:./jars/itextpdf-5.5.13.3.jar:jars/pdfbox-app-2.0.27.jar Main
