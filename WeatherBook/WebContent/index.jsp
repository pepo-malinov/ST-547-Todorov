<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Howdy partner!</title>

<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="assets/css/main.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.4.1.js" > </script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</head>
<body>
	<header>
		<div>
			<img style="width: 120px;" src="assets/img/weather_icon.png"
				alt="sunshine">
			<h1>WeatherBook</h1>
		</div>
	</header>

	<div class="container">

		<div class="row">
			<div class="col-12 container-stuff">
				<h2>Социална мрежа!</h2>
				<p>Единствената социална мрежа, която не краде информация! :D</p>
				<p style="font-size: 0.1em">Поне за сега...</p>
			</div>
		</div>

		<div class="row">
			<div class="col-7 container-stuff d-none d-md-block">
				<img class="img-fluid" src="assets/img/family.jpg"
					alt="family on pickning">
			</div>

			<div class="col container-stuff">
				<form action="HelloWorldServlet" method="post">


					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text">
									<i class="fa fa-user"></i>
								</span> 
							</div>
							<input class="form-control" type="text"
								name="username" placeholder="Потребител">
						</div>
					</div>
						
					
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text">
									<i class="fa fa-lock"></i>
								</span> 
							</div>							
								
							<input class="form-control" type="password"
							name="password" placeholder="Парола">
						</div>
					</div>

					<input type="hidden" name="router" value="login">

					<button type="submit" class="btn btn-primary"> Влез </button>
					<button type="button" class="btn btn-success pull-right" data-toggle="modal" data-target="#register-modal" id="register"> Регистрация </button>
				
				</form>
			</div>
		</div>

	</div>
	
	<div id="register-modal" class="modal fade" 
	role="dialog" tabindex="-1">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
			<button class="close" data-dismiss="modal"
			aria-label="Close"			>
			<span aria-hidden="true">&times;</span>
			</button>
			<h4>Регистрация</h4>
			</div>
			<div class="modal-body">
				<form id="register-form" action="HelloWorldServlet" method="post">
					<div class="form-group">
						<label for="register_user">Потребител</label>
						<input type="text" class="form-control"
						id="register_user" name="username" placeholder="Потребител">
					</div>
					<div class="form-group">
						<label for="register_email">Email</label>
						<input type="text" class="form-control"
						id="register_email" name="email" placeholder="example@gmail.com">
					</div>
					<div class="form-group">
						<label for="register_pass">Парола</label>
						<input type="password" class="form-control"
						id="register_pass" name="password" placeholder="Парола">
					</div>
					
					<input type="hidden" value="register" name="router" />
					
					<div class="form-group">
						<label for="confirm_register_pass">Повтори паролата</label>
						<input type="password" class="form-control"
						id="confirm_register_pass" name="repeatPassword" placeholder="Парола">
					</div>
				</form>
			</div>
			<div class="modal-footer">
			<button type="button" class="btn btn-default"
			data-dismiss="modal">Затвори</button>
			<button type="submit" form="register-form"
			class="btn btn-success">Регистрация</button>
			</div>
		</div>
	</div>
</div>

<script>
	$('#register').click(function () {
		$('#register-modal').modal();
	});
</script>
	
</body>
</html>