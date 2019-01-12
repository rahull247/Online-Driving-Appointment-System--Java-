<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application Form</title>
</head>

<script type="text/javascript">

function validation(){  
	var x = document.getElementById("l_type").checked;
	var g = document.getElementByName("gender").checked;
	var c = document.getElementById("citizenship").checked;
	var e = document.forms["myform"]["email"].value;
    var atpos = e.indexOf("@");
    var dotpos = e.lastIndexOf(".");
    var cov = document.getElementById("cov").checked;
    var landline = /^([0-9]{4}[\-]{1}[0-9]{7})$/;
    var mobile = /^[1-9]{1}[0-9]{9}$/;
    
   
    
    if(x==false)
    {
    	alert("Select Licence Type");
    	return false;
    }else
    if(g==false)
    {
    	alert("Select Gender");
    	return false;
    }else
    if(c==false)
    {
    	alert("Select Citizenship");
    	return false;
    }else
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=e.length)
    {
        alert("Not a valid e-mail address");
        return false;
    }else
   	if(cov==false)
    {
       	alert("Select Vehicle Type");
       	return false;
    }else
    if (landline.test(document.getElementById("phone").value) || landline.test(document.getElementById("perphone").value))
    {
    	alert("Enter Valid LandLine Number");
    	return false;
    }else
    if(!mobile.test(document.getElementById("mobile").value) || !mobile.test(document.getElementById("permobile").value))
    {
    	alert("Enter Valid Mobile Number");
    	return false;
   	}
    return true;
}
function myFunction() {
    document.getElementById("perflatno").value = document.getElementById("flatno").value;
    document.getElementById("perhouseName").value = document.getElementById("houseName").value;
    document.getElementById("perhouseNo").value = document.getElementById("houseNo").value;
    document.getElementById("perstreet").value = document.getElementById("street").value;
    document.getElementById("perlocality").value = document.getElementById("locality").value;
    document.getElementById("percity").value = document.getElementById("city").value;
    document.getElementById("pertaluka").value = document.getElementById("taluka").value;
    document.getElementById("perdistrict").value = document.getElementById("district").value;
    document.getElementById("perstate").value = document.getElementById("state").value;
    document.getElementById("perpincode").value = document.getElementById("pincode").value;
    document.getElementById("perphone").value = document.getElementById("phone").value;
    document.getElementById("permobile").value = document.getElementById("mobile").value;   
    
}


function giveRtos()
{
	var state=document.getElementById("state").value;
	var x = document.getElementById("l_type").value;
	window.location="Givertos?state="+state+"&x="+x;

	}

</script>



<body>
<form name="myform" method="post" action="InsertApplicantDetail"
	onsubmit="return validation()">
<fieldset>
<div><BR>


<p align="right">Application No&nbsp;&nbsp; <input type="text"
	id="appId" name="appId" value="<%=request.getAttribute("applId") %>" readonly></p>

<center>
<h3><b>Form of Application for New Licence to Drive a Motor
Vehicle <br>
(Read the instructions on page-5 carefully before filling the form)</b></h3>
</center>
<p align="right">*
<% int dlflag=Integer.parseInt(request.getParameter("dlflag")); 
if(dlflag==0)
{%>
 <input type="radio" name="l_type" value="LL"
	id=l_type checked="checked">LL &nbsp;&nbsp;&nbsp;&nbsp;
	<input type=radio name=l_type id=l_type value="LL" disabled="disabled">DL
	<%} 
	else { %>
	<input type=radio name=l_type value="DL" id=l_type disabled="disabled">LL &nbsp;&nbsp;&nbsp;&nbsp; 
	<input type="radio"	name="l_type" value="DL" id=l_type checked="checked"> DL
	
<%} %>
</p>
<% int dlflag1=Integer.parseInt(request.getParameter("dlflag"));
  if(dlflag1==1)
  {%>
<p align="right">Licence No.&nbsp;&nbsp; <input type="text"
	id="licenceNo" name="licenceNo" required>
<%} %>
</p>
<p align="left">
<table cellspacing=10>
	<tr>
		<td>State * &nbsp;&nbsp;</td>
		<td><select name="state" onchange="giveRtos(this)" id=state>
		<%ArrayList name = (ArrayList) request.getAttribute("namestate");%>
			
			
			
			
			<%
				ArrayList arr = (ArrayList) request.getAttribute("state");
			

			%>
			<option value="0">Select Any</option>
			<%
			
				for (int j = 0; j < arr.size(); j++) {
					ArrayList f = (ArrayList) arr.get(j);
					
					for (int i = 0; i < f.size(); i++) {
			%>
			<option value="<%=f.get(i)%>" <%if(name!=null){%><%= (f.get(i).equals(name.get(0)))?"selected":"" %><%} %> ><%=f.get(i)%></option>
			<%
				}
				}
			%>			
		</select></td>
	</tr>
	<tr>
		<td>Name of RTO/DTO *&nbsp;&nbsp;</td>
		<td><select name="rtoId">
			<%
				ArrayList arr1 = (ArrayList) request.getAttribute("rtos");
				ArrayList arr2 = (ArrayList) request.getAttribute("id");
			if(arr1==null)
			{%>
			<option value="0">Select State</option>
			<%
				
			}
			else
			{
				for (int i = 0; i < arr1.size(); i++) {
			%>
			<option value="<%=arr1.get(i)%>"><%=arr2.get(i)%></option>

			<%
				}
			}
			%>
		</select></td>
	</tr>
</table>
</div>
</fieldset>


<fieldset>
<br>
<b><u>Part-A</u></b>
<table cellpadding=10>

	<tr>
		<td></td>
		<td>First Name*</td>
		<td>Middle Name</td>
		<td>Last Name</td>
	</tr>
	<tr>
		<td>1. Name of the applicant</td>
		<td><input type=text name=fName required></td>
		<td><input type=text name=mName></td>
		<td><input type=text name=lName></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;Gender&nbsp;*</td>
		<td colspan=2><input type=radio name=gender value=male id=gender>Male&nbsp;&nbsp;
		<input type=radio name=gender value=female id=gender>Female&nbsp;&nbsp;
		<input type=radio name=gender value=others id=gender>Others</td>
	</tr>
	<tr>
		<td>1.1 Date of birth &nbsp;*</td>
		<td><input type=date max="2000-01-01" name=birthday required></td>
	</tr>
	<tr>
		<td>2. Place of Birth&nbsp;*</td>
		<td><input type="text" id="birth_place" name="birth_place"
			required></td>
	</tr>
	<tr>
		<td>3. Nationality</td>
		<td><input type="text" id="nationality" name="nationality"
			required></td>
	</tr>
	<tr>
		<td>3(a). Email id</td>
		<td><input type="text" name="email" id="email" required></td>
	</tr>
	<tr>
		<td>4. Name Of&nbsp;*</td>
		<td>Father<input type="radio" id="1" name="parentFlag" value="1"
			checked></td>
		<td>Guardian<input type="radio" id="2" name="parentFlag"
			value="2"></td>
		<td>Husband<input type="radio" id="3" name="parentFlag" value="3"></td>
	</tr>
	<tr>
		<td></td>
		<td>First Name</td>
		<td>Middle Name</td>
		<td>Last Name</td>
	</tr>
	<tr>
		<td></td>
		<td><input type=text name=parentName required></td>
		<td><input type=text name=fmname></td>
		<td><input type=text name=flname></td>
	</tr>
</table>
<br>
<table style="width: 100%" cellspacing=10>
	<tr>
		<td>5. Permanent address(proof to be enclosed)</td>
		<td></td>
		<td></td>
		<td>6. Present Address</td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;If Your Present Address
		Is Same As Permanent address double click the button
		<button onclick="myFunction()">Click Here</button>
		</td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(a) Flat no</td>
		<td><input type=text name="flatno" id="flatno"></td>
		<td></td>
		<td><input type=text name="perflatno" id="perflatno"></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(b)
		Flat/House Name</td>
		<td><input type=text name=houseName id=houseName></td>
		<td></td>
		<td><input type=text name=perflatname id=perhouseName></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(c) House
		no/Plot no</td>
		<td><input type=text name=houseNo id=houseNo></td>
		<td></td>
		<td><input type=text name=perhouseNo id=perhouseNo></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(d) Street</td>
		<td><input type="text" name="street" id=street></td>
		<td></td>
		<td><input type=text name="perstreet" id=perstreet></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(e) Locality</td>
		<td><input type="text" name="locality" id=locality></td>
		<td></td>
		<td><input type=text name=perlocality id=perlocality></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(f)
		Villege/Town/City</td>
		<td><input type="text" name="city" id=city></td>
		<td></td>
		<td><input type=text name=percity id=percity></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(g)
		Taluka/Mandal</td>
		<td><input type="text" name="taluka" id="taluka"></td>
		<td></td>
		<td><input type=text name=pertaluka id="pertaluka"></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(h) District</td>
		<td><input type="text" name="district" id="district"></td>
		<td></td>
		<td><input type=text name=perdistrict id=perdistrict></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(i) State</td>
		<td><select name=addrstate id=state>
		<option value="null" ></option>
			<%
				ArrayList statelist = (ArrayList) request.getAttribute("state");
				for (int j = 0; j < statelist.size(); j++) {
					ArrayList f = (ArrayList) arr.get(j);
					for (int i = 0; i < f.size(); i++) {
			%>
			<option value="<%=f.get(i)%>"><%=f.get(i)%></option>
			<%
				}
				}
			%>

		</select></td>

		<td></td>
		<td><select name=peraddrstate id=perstate>
		<option value="null" ></option>
			<%
				ArrayList perstatelist = (ArrayList) request.getAttribute("state");
				for (int j = 0; j < perstatelist.size(); j++) {
					ArrayList f = (ArrayList) arr.get(j);
					for (int i = 0; i < f.size(); i++) {
			%>
			<option value="<%=f.get(i)%>"><%=f.get(i)%></option>
			<%
				}
				}
			%>

		</select></td>

	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(j) Pin Code</td>
		<td><input type="text" name="pincode" id="pincode" required></td>
		<td></td>
		<td><input type=text name=perpincode id="perpincode"></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(k) Phone No- (Format-0202-7472616)</td>
		<td><input type="text" name="phone" id="phone"></td>
		<td></td>
		<td><input type="number" name=perphoneno id="perphone"></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(l) Mobile
		No*</td>
		<td><input type="number" name="mobile" id="mobile" ></td>
		<td></td>
		<td><input type="number" name=permobileno id="permobile"></td>
	</tr>
</table>
<table cellspacing=20>
	<tr>
		<td>7. Citizenship Status By&nbsp;&nbsp;*</td>
		<td><input type="radio" name="citizenship_type" value="birth"
			id=citizenship>Birth&nbsp;&nbsp; <input type="radio"
			name="citizenship_type" value="registration" id=citizenship>Registration&nbsp;&nbsp;
		<input type="radio" name="citizenship_type" value="decent"
			id=citizenship>Decent&nbsp;&nbsp; <input type="radio"
			name="citizenship_type" value="naturalization" id=citizenship>Naturalization&nbsp;&nbsp;
		<input type="radio" name="citizenship_type" value="nonindian"
			id=citizenship>Non Indian&nbsp;&nbsp;</td>
	</tr>
	<tr>
		<td>8. Education Qualification&nbsp;&nbsp;*</td>
		<td><input type=text name=education required></td>
	</tr>
	<tr>
		<td>9. Identification Marks</td>
		<td><input type="text" id="identification" name="identification"></td>
	</tr>
	<tr>
		<td>10. Blood Group&nbsp;&nbsp;*</td>
		<td><select name=blood_grp>
			<option value="A+">A+</option>
			<option value="A">A-</option>
			<option value="B+">B+</option>
			<option value="B">B-</option>
			<option value="AB+">AB+</option>
			<option value="AB">AB-</option>
			<option value="O+">O+</option>
			<option value="O-">O-</option>
		</select></td>
	</tr>
</table>
</fieldset>

<fieldset>
<p align="left"><b><u>Part-B</u></b></p>
<p align="right">&nbsp;Application No &nbsp;&nbsp;<input type="text"
	id="appId" value="<%=request.getAttribute("applId") %>" readonly></p>
<br>
<b>11. &nbsp;&nbsp;Requested Transaction service(with class of
vehicle)&nbsp;&nbsp;*</b><br>
<br>
<table border="2" style="width: 100%" cellpadding=5>
	<tr>
		<th><b> Sr. No. </b></th>
		<th><b> DESCRIPTION TYPE OF VEHICLE </b></th>
		<th><b> LL </b></th>
	</tr>
	<%
		ArrayList vidarr = (ArrayList) request.getAttribute("v_id");
		ArrayList covarr = (ArrayList) request.getAttribute("cov");
		for (int i = 0; i < vidarr.size(); i++) {
	%>
	<tr>
		<td><%=i + 1%></td>
		<td><%=covarr.get(i)%></td>
		<td><input type="radio" name="cov" value="<%=vidarr.get(i)%>"
			id=cov></td>
	</tr>
	<%
		}
	%>
</table>
<br>
<br>
<b><u>Part-C</u></b><br>
<br>
12)&nbsp;&nbsp;<b>List Of Enclosures (For address proof and birth
proof) <br>
<font color="red"> &nbsp;&nbsp;&nbsp;(Applicant should produce
the original documents before Licensing Authority at the office.) <br>
&nbsp;&nbsp;&nbsp;NOTE : Affidavit to be submitted with valid reasons of
not having any other document as address proof. </font> </b>
<table border="1" style="width: 100%" cellpadding=5>
	<tr>
		<th>Document Type</th>
		<th>Certificate No./Badge No.,etc</th>
		<th>Issuing Authority</th>
		<th>Date Of Issue<br>
		(MM-DD-YY)</th>
	</tr>
	<tr>
		<td><select name=proof1>
			<option value="none">-None-</option>
			<option value="adharcard">AADHAAR CARD</option>
			<option value="sscresult">SSC Result</option>
			<option value="hscresult">HSC Result</option>
			<option value="pancard">PANCARD</option>
			<option value="RationCard">RATION CARD</option>
			<option value="electricityBill">ELECTRICITY BILL</option>

		</select></td>
		<td><input type="text" id="licence1" name="licence1"></td>
		<td><input type="text" id="issue1" name="issue1"></td>
		<td><input type=date name=issueDate1 min="1920-01-01"
			max="2016-01-01"></td>
	</tr>
	<tr>
		<td><select name=proof2>
			<option value="none">-None-</option>
			<option value="adharcard">AADHAAR CARD</option>
			<option value="sscresult">SSC Result</option>
			<option value="hscresult">HSC Result</option>
			<option value="pancard">PANCARD</option>
			<option value="RationCard">RATION CARD</option>
			<option value="electricityBill">ELECTRICITY BILL</option>

		</select></td>
		<td><input type="text" id="licence2" name="licence2"></td>
		<td><input type="text" id="issue2" name="issue2"></td>
		<td><input type=date name=issueDate2 min="1920-01-01"
			max="2016-01-01"></td>
	</tr>
	<tr>
		<td><select name=proof3>
			<option value="none">-None-</option>
			<option value="adharcard">AADHAAR CARD</option>
			<option value="sscresult">SSC Result</option>
			<option value="hscresult">HSC Result</option>
			<option value="pancard">PANCARD</option>
			<option value="RationCard">RATION CARD</option>
			<option value="electricityBill">ELECTRICITY BILL</option>
		</select></td>
		<td><input type="text" id="licence3" name="licence3"></td>
		<td><input type="text" id="issue3" name="issue3"></td>
		<td><input type=date name=issueDate3 min="1920-12-31"
			max="2016-01-01"></td>
	</tr>
	<tr>
		<td><select name=proof4>
			<option value="none">-None-</option>
			<option value="adharcard">AADHAAR CARD</option>
			<option value="sscresult">SSC Result</option>
			<option value="hscresult">HSC Result</option>
			<option value="pancard">PANCARD</option>
			<option value="RationCard">RATION CARD</option>
			<option value="electricityBill">ELECTRICITY BILL</option>
		</select></td>
		<td><input type="text" id="licence4" name="licence4"></td>
		<td><input type="text" id="issue4" name="issue4"></td>
		<td><input type=date name=issueDate4 min="1920-01-01"
			max="2016-01-01"></td>
	</tr>
</table>
<br>
<br>
<b><u>Part-D</u></b> <br>
<br>
<table border=1 cellpadding=5 style="width: 100%">
	<tr>
		<td>13)&nbsp;&nbsp; I have submitted along with my application
		for Learner’s<br>
		Licence the written consent my parent/guardian - (For Candidates
		having age below 18 years)</td>
		<td><input type="radio" id="13yes" name="ynbutton13"
			value="13yes">Yes&nbsp;&nbsp;</td>
		<td><input type="radio" id="13no" name="ynbutton13" value="13no"
			checked>NO</td>
	</tr>
	<tr>
		<td>14)&nbsp;&nbsp; I have submitted along with my application
		for Learner’s Licence , I<br>
		enclosed all the Necessary Enclosures / Certificates -</td>
		<td><input type="radio" id="14yes" name="ynbutton14"
			value="14yes">Yes&nbsp;&nbsp;</td>
		<td><input type="radio" id="14no" name="ynbutton14" value="14no"
			checked>NO</td>
	</tr>
	<tr>
		<td>15)&nbsp;&nbsp; I am exempted from the Medical test under
		rule 6 of the Central<br>
		Motor Vehicles Rules, 1989 (Refer to Page-5)</td>
		<td><input type="radio" id="14yes" name="ynbutton15"
			value="14yes">Yes&nbsp;&nbsp;</td>
		<td><input type="radio" id="14no" name="ynbutton15" value="14no"
			checked>NO</td>
	</tr>
	<tr>
		<td>16)&nbsp;&nbsp; I am exempted from preliminary test under
		rule 11(2) of<br>
		the Central Motor Vehicles Rules, 1989 (Refer to Page-5)</td>
		<td><input type="radio" id="14yes" name="ynbutton16"
			value="14yes">Yes&nbsp;&nbsp;</td>
		<td><input type="radio" id="14no" name="ynbutton16" value="14no"
			checked>NO</td>
	</tr>
	<tr>
		<td>17)&nbsp;&nbsp; I have been convicted / disqualified / my
		Licence was<br>
		cancelled /suspended / my Licence was revoked</td>
		<td><input type="radio" id="14yes" name="ynbutton17"
			value="14yes">Yes&nbsp;&nbsp;</td>
		<td><input type="radio" id="14no" name="ynbutton17" value="14no"
			checked>NO</td>
	</tr>
</table>
</fieldset>

<fieldset>
<p align="right">Application No &nbsp;&nbsp;<input type="text"
	id="appno" value="<%=request.getAttribute("applId") %>" readonly></p>
<br>
<table cellpadding=10>
	<tr>
		<td>(If Yes, attach document)</td>
	</tr>
	<tr>
		<td>If Yes, DL number</td>
		<td><input type="text" id="dlnumber" name="dlnumber"></td>
		<td>Date of conviction(dd-mm-yy)</td>
		<td><input type="date" id="dateconv" name="dateconv"
			max="2016-04-01"></td>
	</tr>
	<tr>
		<td>Reason</td>
		<td><input type="text" id="reason" name="reason"></td>
	</tr>
</table>
<br>
I hereby declare that to the best of my knowledge and belief the
particulars given above are true and I have enclosed all the necessary
documents required as per the rules. <br>
<br>
<br>
<br>
DATE
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Signature Or Thumb impression of applicant <br>
<br>
<br>
<b><u>Part-E</u></b> (Applicable for leraner licence only if aplicant
age is 16 to 18 years) <br>
<br>
<center><b>UNDER SECTION 7(2) OF THE MOTOR VEHICLES ACT,
1988</b></center>
<br>
<br>
Shri / Kumari......................<br>
<br>
son/daughter of...........................who is a minor is under my
care and I accept forhis/her driving.<br>
<br>
If at a later date I decide not to accept responsibility for his/her
driving I shall intimate the licensing authority in writing for the
cancellation of the licence.<br>
I give my consent for his/her obtaining learner’s licence. <br>
<br>
<br>
<br>
Name and full address of the parent/guardian
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Signature And Thumb <br>
<br>
<br>

<table cellspacing=25>
	<tr>
		<td>Name of the Guardian</td>
		<td>:</td>
		<td>.......................................................</td>
	</tr>
	<tr>
		<td>Pincode</td>
		<td>:</td>
		<td>.......................................................</td>
	</tr>
	<tr>
		<td>District</td>
		<td>:</td>
		<td>.......................................................</td>
	</tr>
	<tr>
		<td>City</td>
		<td>:</td>
		<td>.......................................................</td>
	</tr>
	<tr>
		<td>Address</td>
		<td>:</td>
		<td>.......................................................</td>
	</tr>
	<tr>
		<td>Relationship</td>
		<td>:</td>
		<td>.......................................................</td>
	</tr>
</table>
<br>
<br>
(To be signed in the presence of the licensing authority or person
authorized in this behalf by the licensing authority) <br>
<br>
<b><u>Part-F</u></b> <br>
<br>
<center><b>OFFICE USE ONLY</b></center>
<br>
<br>
1) The applicant is exempted from the medical test under r. 6 and the
preliminary test under r. 11(2)<br>
of the Central Motor Vehicles Rules, 1989.<br>
Learner’s licence may be issued
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;................................... <br>
<br>
2) The applicant was tested with reference to r. 11(1) of the Central
Motor Vehicles Rules, 1989.<br>
He has passed the test.<br>
Learner’s licence may be issued
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;...............................<br>
<br>
3) He / She has failed
in&nbsp;&nbsp;&nbsp;................&nbsp;&nbsp;LL
&nbsp;&nbsp;&nbsp;................DL<br>
<br>
(Reasons should be specified).............................<br>
<br>
4) Registration Mark(s) of the vehicle(s) on which Driving Skill test
was conducted<br>
<table border="2" style="width: 100%" cellpadding=5>
	<tr>
		<td>S.NO.</td>
		<td>
		<center>Class of Vehicle</center>
		</td>
		<td>
		<center>Registration Mark of<br>
		the vehicle</center>
		</td>
		<td>
		<center>Details of Skill Test</center>
		</td>
		<td>
		<center>Result</center>
		</td>
	</tr>
	<tr>
		<td>&nbsp; &nbsp;</td>
		<td></td>
		<td></td>
		<td></td>
	</tr>

	<tr>
		<td>&nbsp; &nbsp;</td>
		<td></td>
		<td></td>
		<td></td>
	</tr>

	<tr>
		<td>&nbsp; &nbsp;</td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table>
</fieldset>

<fieldset>
<p align="right">Application No &nbsp;&nbsp;<input type="text"
	id="appno" value="<%=request.getAttribute("applId") %>" readonly></p>
<br>
<br>
5) Learner’s licence may be refused.<br>
<br>
6) Signature of licensing authority or other person authorized in this
behalf<br>
<br>
*Strike out whichever is inapplicable.<br>
<p align="right">Signature Of Issuing Authority</p>
<br>
<br>
<p align="right"><input type="submit" value="Clear"> <input
	type="submit" value="Submit"></p>
	</fieldset>
</form>
</body>
</html>