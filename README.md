# demo-nopcommerce-automation
RUN mvn package install  (for run both test one after one)

#User can run individual RegistrationTest and OrderTest file

#for running on linux based OS, use "crontab -e"

then, modify the schedule time as below

"0 0 * * * /path/to/nopcommerce_automated_project.sh"

** script file has been added into scripts folder


for sending report, email has been chosen 

for sending the report to a specific email:

"pip install smtplib"


