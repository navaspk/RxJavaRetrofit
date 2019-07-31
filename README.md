# RxJavaRetrofit
HLD:
This has been implemented based on MVP architecture. The model class includes NyPopularService class used to query the data from server.
In order to query from the server we are using Retrofit library.
View: under view, both activity and fragments taking care to responsibility to display the contents.
Presenter: We have an pojo class (PopularNews) to feed the content from server.

LLD:
Platform : Android
Language: Java
Library used: Retrofit, RxJava, Okhttp and Gson
DataStructure : List

Retrofit is a type safe http client used to getting data from server, it calling to server by using java interface with many request methods
and request params. Okhttp used for network call.
RxJava is another libarary added in this to get asynchronous call. This is working based on observer and observable concept. Now a days RxJava
is more important as this is having good feature like able to perform network call, perform synchronous and asynchronous call, performing
background listening.

Class usage:
View :
1. PopularMainActivity : main activity : this is containing navigation view, tool bar and framelayout to add the fragment
2. PopularHomeFragment : this fragment is adding in main activity to show the content from server. This is having recycler view
3. PopularAdapter : This is adapter class of recycler view to display the ui

Presenter:
PopularNews is POJO class to store the data from server. Once retrofit provinding response, same time automatically feeding into POJO class 
by Gson. After that Observable return the pojo class object asynchronously. So that observer will notify once the data emited from observable.

Model:
NyPopularService is main model class for query to server which used retrofit.
