#!/bin/bash

# Maven Path 
MAVEN_PATH="/downloaded maven directory/maven/bin/mvn"

# Project directory 
PROJECT_DIR="/******/project directory"

# Email configuration (replace with your details)
EMAIL_SENDER = "email@gmail.com"
EMAIL_PASSWORD = "gmail_password"
EMAIL_RECEIVER = "abc@gmail.com"
EMAIL_SUBJECT = "Selenium Test Report - $(date +'%Y-%m-%d')"

"$MAVEN_PATH" package install

if [ $? -ne 0 ]; then
  echo "Error: Maven build failed." >> error.log
fi

python <<EOF
import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText

REPORT_PATH = "$PROJECT_DIR/target/surefire-reports/TEST-*.html"

msg = MIMEMultipart()
msg['From'] = EMAIL_SENDER
msg['To'] = EMAIL_RECEIVER
msg['Subject'] = EMAIL_SUBJECT

with open(REPORT_PATH, 'r') as f:
    report_content = f.read()

body = MIMEText(report_content, 'html')
msg.attach(body)

server = smtplib.SMTP('smtp.gmail.com', 587)
server.starttls()
server.login(EMAIL_SENDER, EMAIL_PASSWORD)
server.sendmail(EMAIL_SENDER, EMAIL_RECEIVER, msg.as_string())
server.quit()

print("Email sent with Selenium test report.")
EOF

if [ $? -ne 0 ]; then
  echo "Error: Email sending failed." >> error.log
fi
