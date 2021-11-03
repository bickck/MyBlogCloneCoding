<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<h2>Stacked form</h2>
	<form>

		<input type="hidden" id="id" value="${principal.user.id }">
		<div class="form-group">
			<label for="userName">userName:</label> <input type="text"
				value="${principal.user.username }" class="form-control"
				id="userName" placeholder="Enter userName" name="email"
				readonly="readonly">
		</div>
		<div class="form-group">
			<label for="email">Email:</label> <input type="email"
				class="form-control" id="email" placeholder="Enter email"
				name="email">
		</div>

		<div class="form-group">
			<label for="pwd">Password:</label> <input type="password"
				value="${principal.user.password }" class="form-control"
				id="password" placeholder="Enter password" name="pswd">
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">회원 수정 완료</button>
</div>
<script src="/blog/js/user.js"></script>

<%@ include file="../layout/footer.jsp"%>