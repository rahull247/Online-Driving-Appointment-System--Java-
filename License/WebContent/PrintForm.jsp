<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
div {
    background-color: lightgrey;
    width: 140px;
height: 130px;
    padding: 5px;
    border: 2px solid navy;
    margin-left: 20cm;
	
}

header {
    background-color:white;
    color:black;
    text-align:center;
    padding:5px;	 
}
nav {
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:100px;
    float:left;
    padding:5px;	      
}
section {
	height:200px;
    width:45px;
    float:left;
    padding:10px;	 	 
}
artical {
    width:350px;

    padding:10px;	 	 
}

footer {
    background-color:white;
    color:black;
    clear:both;
    text-align:left ;
    padding-left:60px;	 	 
}
table{
    border-collapse: separate;
    border-spacing: 10px;
}



</style>
<title>Print Application Form</title>
</head>
<body leftmargin="51" rightmargin="51">
<font size="4">
<br>
<%
ArrayList arr = (ArrayList) request.getAttribute("details");

%>
<header><h2>"Form 2"</h2><p align="right">Web Application No:- <%=	arr.get(0)%></p></header>
<center><h3>[ see rule 10 ]</h3></center>
<br>
<center><h1>FORM OF APPLICATION FOR THE GRANT OF LEARNER'S LICENCE</h1></center>
<section><div><center><br><br>Space For Passport size Photograph</center></div></section>
<br><br><br><br>
<section>To<br><br>
The Licensing Authority,<br><br>
DY.RTO,PIMPRI-CHINCHWAD</section>
<br>
<footer>I here by apply for a licence authorising me to drive as a learner, the following motor vechicle(s):-</footer><br>
<footer> <%=	arr.get(11)%></footer>
<br><br><br>
<center><h2>PARTICULARS TO BE FURNISHED BY APPLICANT</h2></center>
<center>
<table width=100% align="right" cellpadding="5" >
<tr>
<td><footer>1.  Full Name    :    </footer></td><td> <%=	arr.get(1)%></td>
</tr>
<tr>
<td><footer> 2.  Daughter of  :    </footer></td><td> <%=	arr.get(2)%></td>
</tr>
<tr><td>
<footer> 3.Permanant Address<br> (Electoral Roll / Life Insurance Policy / Passport / Pay Slip issued by <br> any
office of the Central Government / State Government or a local body /<br>
 Any other documents as may be prescribed by the State Government /<br>
 Affidavit sworn before an executive magistrate or a First Class Judicial<br>
 Magistrate or a Notary Public to         :    </footer></td><td><% if(arr.get(3)==null){%>
----
<%}else
{%>
<%=arr.get(3)%>
<%} %></td>
</tr>
<tr>
<td><footer> 4.  Temporary Address/Official Address if any  :    </footer></td><td> <% if(arr.get(4)==null){%>
----
<%}else
{%>
<%=arr.get(4)%>
<%} %></td>
</tr>
<tr>
<td><footer> 6.Date of birth<br>
 (Birth certificate / school certificate /<br>  affidavit sworn before an<br>
 Executive Magistrate or a First Class Judicial Magistrate or a
 Notary public to be enclosed).  :    </footer></td><td> <%=	arr.get(5)%></td>
</tr>
<tr>
<td><footer> 7.Place Of Birth  :    </footer></td><td> <%=	arr.get(6)%></td>
</tr>
<tr>
<td><footer>9. Education Qualification  :    </footer></td><td> <%=	arr.get(7)%></td>
</tr>
<tr>
<td><footer>10. Identification Mark(s)  :    </footer></td><td> <% if(arr.get(8)==null){%>
----
<%}else
{%>
<%=arr.get(8)%>
<%} %></td>
</tr>
<tr>
<td><footer>11. Declaration of citizenship status<br>
(i) If deemed Citizen or Citizen by Birth<br>
(Birth certificate and school certificate)<br>
(In Support of Citizen ship as Indian to be enclosed)<br>
(ii) If Citizenship is acquired by Descent / Registration<br>
(In case Citizenship acquied by Descent, Birth Certificate,<br>
land / property document of parent / in case of Citizenship acquired<br>
by registration certificate to be enclosed)<br>
(iii) If Citizenship by Naturalization<br>
(Certificate of Naturalization and<br>
Certificate of Registration to be enclosed)<br>
(iv) If non-Indian Citizen</footer></td><td><%=	arr.get(9)%></td>
</tr>
<tr>
<td><footer>12. Blood Group<br>
RH(Rhesus) factor   </footer></td><td> <%=	arr.get(10)%></td>
</tr>

<tr>
<td><footer>13 I hold an effective driving licence to Drive: Motor Cycle /Light<br>
Motor Vehicle / Transport Vehicle with effect from.</footer></td><td> <%=	arr.get(11)%></td>
</tr>

<tr>
<td><footer>14 Particulars of any driving licence previously held by applicant. Whether it was<br>
cancelled and if so, for what reason</footer></td><td> </td>
</tr>

<tr>
<td><footer>15 Particulars of any learners licence previously held by applicant in respect of the<br>
description of vehicle to which the applicant has applied.</footer></td><td></td>
</tr>

<tr>
<td><footer>16 Have you been disqualified for holding or obtaining driving licence or learner's licence.<br>
If so, for what reason.</footer></td><td> </td>
</tr>

<tr>
<td colspan=2><footer>17. I enclose three copies of my recent photograph
(Passport size photograph)</footer></td>
</tr>
<tr>
<td colspan=2><footer>18. I enclose medical fitness certificate dated .................................... issued by ................................... doctor</footer></td>
</tr>
<tr>
<td colspan=2><footer>19 I have submitted along with my earlier application for Learner's licence / I enclose the written consent of parent / guardian ( In<br>
the case of applicant being a minor)</footer></td>
</tr>
<tr>
<td colspan=2><footer>20 I enclose driving certificate dated ..................... issued by ............................................... (Name and address of the driving<br>
school)</footer></td>
</tr>

<tr>
<td colspan=2><footer>21 Have paid the fee of Rs</footer></td>
</tr>

<tr>
<td colspan=2><footer>22 I am exempted from the medical test under rule 6 of the Central Motor Vehicles Rules, 1989.</footer></td>
</tr>

<tr>
<td colspan=2><footer>23 I am exempted from the preliminary test under rule 11(2) of the Central Motor Vehicles Rules 1989.</footer></td>
</tr>

<tr>
<td colspan=2><footer>* Strike out whichever is inapplicable</footer></td>
</tr>

<tr>
<td colspan=2><footer>Date............................</footer></td>
</tr>

<tr>
<td><footer>Specimen Signature or Thumb impression of Applicant.</footer></td><td><br><br><br>Signature or Thumb impression of Applicant<br>
<h5><%=((String)arr.get(1)).toUpperCase()%></h5></td>
</tr>
<tr>
<td colspan=2><footer><h5>1.</h5></footer></td>
</tr>
<tr>
<td colspan=2><footer><h5>2.</h5></footer></td>
</tr>
<tr>
<td colspan=2><center><h3>DECLARATION UNDER SUB-SECTION(2) OF SECTION 7 OF THE MOTOR VEHICLE ACT 1988</h3></center></td>
</tr>
<tr>
<td colspan=2><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Shri / Smt / Kumari ................................. Son / daughter of ........................................... who is a minor is under my care and I<br><br>
accept responsibility / for his / her driving. If at a later date I decide not to accept responsibility of his/her driving, I shall<br><br>
intimate the licence authority in writing for the cancellation of the licence. I give my consent for his/her obtaining learner's<br><br>
License.</center></td>
</tr>
<tr>
<td>
</td>
<td>
Signature......................................................<br><br>
Name and full address of the parent / guardian<br><br>
............................................................................<br><br>
............................................................................<br><br>
Relationship....................................................<br><br>
</td>
</tr>
<tr>
<td colspan=2><center>(To be signed in the presence of the licensing authority or person authorised in the behalf by the Licensing</center></td>
</tr>
<tr>
<td colspan=2><center><h2>For official use</h2></center></td>
</tr>
<tr>
<td colspan=2><footer>The applicant is exempted from the medical test under rule 6 and the preliminary test under rule 11(2) of the Central Motor<br>
Vehicles Rule, 1989.</footer></td>
</tr>

<tr>
<td colspan=2><footer>Learner's licence may be issued.</footer></td>
</tr>

<tr>
<td colspan=2><footer>The applicant was tested with reference of rule 11(1) of the Central Motor Vehicle Rules, 1989.</footer></td>
</tr>

<tr>
<td colspan=2><footer>He has passed the test. Learner's Licence may be issued.</footer></td>
</tr>

<tr>
<td colspan=2><footer>Learner's licence may be refused.</footer></td>
</tr>

<tr>
<td>
</td>
<td>
<br>Signature of licensing authority or other<br><br>
Person authorized in the behalf.
</td>
</tr>

<tr>
<td colspan=2><footer><h4>* Strike out whichever is inapplicable.</h4></footer></td>
</tr>
<tr>
<td colspan=2><footer>Note: The application along with the scanned copies of the required documents may also be sent to the concerned Licensing<br>
Authority through Electronic Mail, if allowed by the concerned State Government / Union Territory</footer></td>
</tr>
<tr>
<td colspan=2><footer>In such cases, the Licensing Authority shall scrutinse the application and intimate the applicant about the acceptance / any /<br>
discrepancy.</footer></td>
</tr>
<tr>
<td colspan=2><footer>In case the application is accepted, the applicant shall be intimated through Electornic mail to report to the Authority concerned on<br>
a appointed date along with the documents for further verification, submission of application fee and examination of the applicant.</footer></td>
</tr>
<tr>
<td colspan=2><footer>Learner's licence may be refused.</footer></td>
</tr>
<tr>
<td colspan=2><footer>Learner's licence may be refused.</footer></td>
</tr>


</table>
</center>
</font>
</body>
</html>