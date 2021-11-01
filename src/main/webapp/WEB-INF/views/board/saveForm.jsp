<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	글쓰기 화면
	<form>
		<div class="form-group">
			<label for="title">TiTle:</label> 
			<input type="text" id="title"
				class="form-control" placeholder="Enter title">
		</div>

		<div class="form-group">
			<label for="comment">Content:</label>
			<textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">글쓰기 완료</button>
</div>

<script>
	$('.summernote').summernote(
			{
				tabsize : 2,
				height : 120,
				toolbar : [ [ 'style', [ 'style' ] ],
						[ 'font', [ 'bold', 'underline', 'clear' ] ],
						[ 'color', [ 'color' ] ],
						[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
						[ 'table', [ 'table' ] ],
						[ 'insert', [ 'link', 'picture', 'video' ] ],
						[ 'view', [ 'fullscreen', 'codeview', 'help' ] ] ]
			});
</script>
<script src="/js/board.js"/>
<%@ include file="../layout/footer.jsp"%>