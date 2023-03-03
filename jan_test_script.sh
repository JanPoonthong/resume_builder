javac -d ./build -cp ./jars/itextpdf-5.5.13.3.jar:jars/pdfbox-app-2.0.27.jar:jars/commons-lang3-3.12.0.jar src/*.java
{
  echo "Jan Poonthong"
  echo "AI Engineer"
  echo "Koh Samui, Thailand"
  echo "janpoonthong628@gmail.com"
  echo "0987913490"
  echo "https://janpoonthong.github.io/portfolio"
  echo "I am a qualified and professional web developer with five years of experience in database administration and website design. Strong creative and analytical skills. Team player with an eye for detail."
  echo "jan_profile.jpg"
  echo "start"
  echo  "Really Great Company"
  echo  "Application Developer"
  echo "2016-2019"
  echo  "Database administration and website design Built the logic for a streamlined ad-serving platform that scaled Educational institutions and online classroom management"
  echo "done"
} | java -cp ./build:./jars/itextpdf-5.5.13.3.jar:jars/pdfbox-app-2.0.27.jar:jars/commons-lang3-3.12.0.jar Main
