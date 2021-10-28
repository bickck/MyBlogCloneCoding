<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file = "../layout/header.jsp" %>

	<div class="container">
		<h2>Stacked form</h2>
		<form>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" placeholder="Enter email"
					name="email">
			</div>
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
			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember">
					Remember me
				</label>
			</div>
		</form>
		<button id ="btn-save" class="btn btn-primary">회원가입완료</button>
	</div>
<script src="/blog/js/user.js"></script>

<%@ include file = "../layout/footer.jsp" %>