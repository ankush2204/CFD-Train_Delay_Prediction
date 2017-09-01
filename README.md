Problems Targeted:

With the growing unpredictabilty of arrival and departure times of Indian Railway trains , hence hampering the traveller’s schedule, we have come up with a solution wherein customers can behorehand get the predicted timings of arrival of any future train. This is a huge problem when considered running trains in India specially, and needs to be solved. With Machine learning finding its applications in almost all fields is yet to be implemented in such a scenario for welfare of travellers. We think our project could be a spark for starting work in this field.  

Description:

We have designed an Android application which actually predicts the delay time and henceforth, the arrival/departure time of a future train. This could be achieved by collecting real data of trains which ran previously. For this we made a web crawler which actually helped us to crop down real data from net. 

Feature Engineering:

On crawling real data from net, we sat back to think of features which alter on every particular run of any train. In India, major train delay issues happen due to weather and climatic conditions. For which we also crawled real data from net and took it into consideration. Also railway traffic remains a major factor which we werent able to inculcate in our model. Although this could have been a good area to work upon, but due to lack of time we limited ourselves to only considering climatic conditions of every stop of that particular train.

Training and Testing:

After getting the appropriate data with delay times of every run, we started our Modelling by trying some Machine Learning algorithms to train data. After trying almost all models we settled with Linear Regression for predicting delay times. The training data had data of all trains that ran in 2016. 


Constraints on input:

We have only included the booking dates of March, 2017. And that to for Mumbai to Delhi(NZM).

Future Work:

This could be expanded to all trains and an app could be built wherein customer puts SOURCE NAME, DESTINATION NAME and DATE, and the app shows a list of trains on that date with an extra column containing predicted timings of every train.
Also this could be linked to IRCTC for further ticket bookings.


Steps to run the project:

1.	Install the apk file "Cliser.apk" on any android device with android version 4.4.0 or higher.
2.  Install these python libraries numpy,pandas and scikit-learn. 
3. Keep the "server.py" and "ngrok.exe" files in any suitable location on your computer and go to that location on cmd.
4. Start the server in cmd using the command "python server.py PORT_NO" .
5. In another cmd window, run the following command to bring the localhost server online: "ngrok http PORT_NO"
6. Enter the address provided by ngrok in the app in suitable format.
7. Now, enter the train number and date of journey in suitable format in the Android app and press the run button.
8. Wait for sometime, the message will be displayed in place of the Result text below the Run button depicting the predicted delay.


Team Members:
1. Ankush Patel
2. Suraj Tripathi
3. Ujjawal Prasad


