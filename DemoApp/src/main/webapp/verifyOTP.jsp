<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>OTP Verification</h1>
<form action="VerifyOTPServlet" method="post">
	<label>ENTER OTP : </label>
	<input type="text" required="required" name="enteredOTP">
	<button type="submit">Submit OTP</button>
</form>
</body>
</html>