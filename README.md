# DAT153 Assignment 2 - Quiz App (Android)

Group no. 8

Storage: Android Rooms 

<h1>Authors:</h1>

Even Sleire, Magnus Gjøsund, Frede Berdal



<h1>Testing using Gradlew:</h1> 

running command: gradlew.bat cAT 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<div id="content">
<h1>Test Summary</h1>
<div id="summary">
<table>
<tr>
<td>
<div class="summaryGroup">
<table>
<tr>
<td>
<div class="infoBox" id="tests">
<div class="counter">7</div>
<p>tests</p>
</div>
</td>
<td>
<div class="infoBox" id="failures">
<div class="counter">0</div>
<p>failures</p>
</div>
</td>
<td>
<div class="infoBox" id="duration">
<div class="counter">17.365s</div>
<p>duration</p>
</div>
</td>
</tr>
</table>
</div>
</td>
<td>
<div class="infoBox success" id="successRate">
<div class="percent">100%</div>
<p>successful</p>
</div>
</td>
</tr>
</table>
</div>
<div id="tabs">
<ul class="tabLinks">
<li>
<a href="#tab0">Packages</a>
</li>
<li>
<a href="#tab1">Classes</a>
</li>
</ul>
<div id="tab0" class="tab">
<h2>Packages</h2>
<table>
<thead>
<tr>
<th>Package</th>
<th>Tests</th>
<th>Failures</th>
<th>Duration</th>
<th>Success rate</th>
</tr>
</thead>
<tbody>
<tr>
<td class="success">
<a href="default-package.html">default-package</a>
</td>
<td>0</td>
<td>0</td>
<td>-</td>
<td class="success">-</td>
</tr>
<tr>
<td class="success">
<a href="com.example.quizapp_oblig1.html">com.example.quizapp_oblig1</a>
</td>
<td>7</td>
<td>0</td>
<td>17.365s</td>
<td class="success">100%</td>
</tr>
</tbody>
</table>
</div>
<div id="tab1" class="tab">
<h2>Classes</h2>
<table>
<thead>
<tr>
<th>Class</th>
<th>Tests</th>
<th>Failures</th>
<th>Duration</th>
<th>Success rate</th>
</tr>
</thead>
<tbody>
<tr>
<td class="success"/>
<a href=".html"></a>
<td>0</td>
<td>0</td>
<td>-</td>
<td class="success">-</td>
</tr>
<tr>
<td class="success"/>
<a href="com.example.quizapp_oblig1.AddStudentActivityTest.html">com.example.quizapp_oblig1.AddStudentActivityTest</a>
<td>1</td>
<td>0</td>
<td>6.000s</td>
<td class="success">100%</td>
</tr>
<tr>
<td class="success"/>
<a href="com.example.quizapp_oblig1.DatabaseTest.html">com.example.quizapp_oblig1.DatabaseTest</a>
<td>3</td>
<td>0</td>
<td>0.568s</td>
<td class="success">100%</td>
</tr>
<tr>
<td class="success"/>
<a href="com.example.quizapp_oblig1.MainActivityTest.html">com.example.quizapp_oblig1.MainActivityTest</a>
<td>1</td>
<td>0</td>
<td>2.359s</td>
<td class="success">100%</td>
</tr>
<tr>
<td class="success"/>
<a href="com.example.quizapp_oblig1.QuizActivityTest.html">com.example.quizapp_oblig1.QuizActivityTest</a>
<td>2</td>
<td>0</td>
<td>8.438s</td>
<td class="success">100%</td>
</tr>
</tbody>
</table>
</div>
</div>
<div id="footer">
<p>Generated by 
<a href="http://www.gradle.org">Gradle 7.2</a> at 5. mar. 2022, 22:28:31</p>
</div>
</div>
</body>
  
<h2>APK's used</h2>
 Gradle uses the "app-debug-androidTest.apk"
 In this APK, gradle will find all the relevant test-classes. 
  
<h2>adb commands used</h2>
 To install the tests: 
 adb am instrument 
 
 To run the entire test-package: 
 adb shell am instrument -w com.example.quizapp_oblig1.tests/android.support.test.runner.AndroidJUnitRunner
  
 To run one test-class at a time (example: MainActivityTest): 
 adb shell am instrument -w  \
 -e class com.example.quizapp_oblig1.tests.MainActivityTest \
 com.example.quizapp_oblig1.tests/android.support.test.runner.AndroidJUnitRunner
 
