<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>고객 문의 등록</title>
<link rel="stylesheet" type="text/css" href="./css/cs.css">
</head>
<body>
	<header id="main-header" class="py-2 btn-dark text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>samsamzo 고객 문의 등록</h1>
				</div>
			</div>
		</div>
	</header>
	<section class="py-4 mb-4 bg-light"></section>
	<section id="department">
		<div class="container">
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<div class="card">
						<div class="card-header">
							<h2>문의 등록</h2>
						</div>
						<div class="card-body">
							<form action="CSInsertView.cs" method="post">
								<div class="form-group">
									<label for="cs_title">문의 제목</label> <input type="text"
										id="cs_title" name="cs_title" class="form-control">
								</div>
								<input type="hidden" id="cs_date" name="cs_date"
									value="<%=new java.util.Date()%>">
								<div class="text-center">
									<button type="submit" class="btn btn-primary">문의 일자</button>
								</div>
								<div class="form-group">
									<label for="cs_content">문의 내용</label>
									<textarea id="cs_content" name="cs_content"
										class="form-control"></textarea>
								</div>
								<div class="text-center">
									<button type="submit" class="btn btn-primary">문의 등록</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
