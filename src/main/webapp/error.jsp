
<!DOCTYPE html>
<html lang="en">

<!-- begin::Head -->

<head>
    <meta charset="utf-8"/>
    <title>Error Report</title>
    <meta name="csrf-token" property="token" id="token" content=""/>
    <script src="assets/js/color-modes.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">

    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700|Roboto:300,400,500,600,700">

    <!--end::Web font -->

    <link href="sis/css/all.css?id=3cac66955c801ae67680" rel="stylesheet" type="text/css"/>
    <link href="css/login-6.css" rel="stylesheet" type="text/css"/>
    <style>
        .kt-error-v3 {
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }

        .kt-error-v3 .kt-error_container .kt-error_number > h1 {
            font-size: 15.7rem;
            margin-left: 7.85rem;
            margin-top: 11.4rem;
            font-weight: 500;
            -webkit-text-stroke-width: 0.35rem;
            -moz-text-stroke-width: 0.35rem;
            text-stroke-width: 0.35rem;
            color: #A3DCF0;
            -webkit-text-stroke-color: white;
            -moz-text-stroke-color: white;
            text-stroke-color: white;
        }

        @media  screen and (-ms-high-contrast: active), (-ms-high-contrast: none) {
            .kt-error-v3 .kt-error_container .kt-error_number > h1 {
                color: white;
            }
        }

        .kt-error-v3 .kt-error_container .kt-error_title {
            margin-left: 7.85rem;
            font-size: 2.5rem;
            font-weight: 700;
            color: #48465b;
        }

        .kt-error-v3 .kt-error_container .kt-error_subtitle {
            margin-left: 7.85rem;
            margin-top: 3.57rem;
            font-size: 1.8rem;
            font-weight: 700;
            color: #595d6e;
        }

        .kt-error-v3 .kt-error_container .kt-error_description {
            margin-left: 7.85rem;
            font-size: 1.4rem;
            font-weight: 500;
            color: #74788d;
        }

        @media (max-width: 768px) {
            .kt-error-v3 .kt-error_container .kt-error_number > h1 {
                font-size: 8rem;
                margin-left: 4rem;
                margin-top: 3.5rem;
            }

            .kt-error-v3 .kt-error_container .kt-error_title {
                margin-left: 4rem;
            }

            .kt-error-v3 .kt-error_container .kt-error_subtitle {
                margin-left: 4rem;
                padding-right: 0.5rem;
            }

            .kt-error-v3 .kt-error_container .kt-error_description {
                margin-left: 4rem;
                padding-right: 0.5rem;
            }
        }
    </style>
</head>

<!-- end::Head -->

<!-- begin::Body -->
<body
        class="kt-quick-panel--right kt-demo-panel--right kt-offcanvas-panel--right kt-header--fixed kt-header-mobile--fixed kt-subheader--enabled kt-subheader--fixed kt-subheader--solid kt-aside--enabled kt-aside--fixed kt-page--loading">

<!-- begin:: Page -->
<div class="kt-grid kt-grid--ver kt-grid--root">
    <div class="kt-grid__item kt-grid__item--fluid kt-grid  kt-error-v3"
         style="">
        <div class="kt-error_container">
					<span class="kt-error_number">
						<h1>404</h1>
					</span>
            <p class="kt-error_title kt-font-light">
                How did you get here
            </p>
            <p class="kt-error_subtitle">
                Sorry we can't seem to find the page you're looking for.
            </p>
            <p class="kt-error_description">
                There may be a misspelling in the URL entered,<br>
                or the page you are looking for may no longer exist.
            </p>
            <p style="color: #ffc107">You will be redirected to the home page in <span style="color: #5a152b" id="countdown">3</span> seconds.</p>

            <script>
                let seconds = 3;
                let countdown = setInterval(function() {
                    seconds--;
                    document.getElementById("countdown").textContent = seconds;
                    if (seconds <= 0) {
                        clearInterval(countdown);
                        window.location.href = "http://localhost:8080/index";
                    }
                }, 1000);
            </script>
        </div>
    </div>
</div>

<!-- end:: Page -->

<!-- begin::Global Config(global config for global JS sciprts) --> 
<script>
    var KTAppOptions = {
        "colors": {
            "state": {
                "brand": "#5d78ff",
                "dark": "#282a3c",
                "light": "#ffffff",
                "primary": "#5867dd",
                "success": "#34bfa3",
                "info": "#36a3f7",
                "warning": "#ffb822",
                "danger": "#fd3995"
            },
            "base": {
                "label": [
                    "#c5cbe3",
                    "#a1a8c3",
                    "#3d4465",
                    "#3e4466"
                ],
                "shape": [
                    "#f0f3ff",
                    "#d9dffa",
                    "#afb4d4",
                    "#646c9a"
                ]
            }
        }
    };
</script>

<script src="js/vendor.js?id=0a5a5c465198b585a07e" type="text/javascript"></script>
<script src="js/app.js?id=9c082e4b2f63d36f0262" type="text/javascript"></script>
</body>

<!-- end::Body -->

</html>
