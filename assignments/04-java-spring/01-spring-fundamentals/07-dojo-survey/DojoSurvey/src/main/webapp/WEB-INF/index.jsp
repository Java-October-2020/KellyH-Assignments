<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<div id="wrapper">
			<form method="POST" action="/submit">
				<label>Your name: <input type="text" name="name"></label>
			    <label>Dojo Location: 
					<select name="location">
						<option value="Tulsa">Tulsa</option>
						<option value="San-Francisco">San-Francisco</option>
						<option value="Seattle">Seattle</option>
		  				<option value="Dallas">Dallas</option>
					</select>
				</label>
				<label>Favorite Language:
					<select name="language">
						<option value="Java">Java</option>
						<option value="Python">Python</option>
						<option value="C+">C+</option>
		  				<option value="Ruby">Ruby</option>
					</select>
				</label>
				<label>Comment (optional)
					<textarea rows="4" cols="50" name="comment">Enter text here...</textarea>
				</label>
				<input type="submit">
			</form>
		</div>
	</body>
</html>