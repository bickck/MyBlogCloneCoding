<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file = "../layout/header.jsp" %>

	<div class="container">
		<h2>Stacked form</h2>
		<form action="/action_page.php">
			<div class="form-group">
				<label for="userName">userName:</label> <input type="text"
					class="form-control" id="userName" placeholder="Enter userName"
					name="email">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Enter password"
					name="pswd">
			</div>
			<button type="submit" class="btn btn-primary">회원가입</button>
		</form>
	</div>


<%@ include file = "../layout/footer.jsp" %>