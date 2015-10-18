<?php
require_once('braintree-php-3.5.0/lib/Braintree.php');

Braintree_Configuration::environment('sandbox');

Braintree_Configuration::merchantId('wzgwhjx9djykmyty');
Braintree_Configuration::publicKey('m2g7bhw99gbydrqh');
Braintree_Configuration::privateKey('300db931c84fcaf9c3e0a17edc7b16cb');
?>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>CrimeWatch</title>

    <link href="img/logo.svg" rel="icon">

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/grayscale.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

    <!-- Navigation -->
    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">
                    <i class="fa fa-bolt"></i> <span class="light">Crime</span>Watch
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#features">Features</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#findCrimes">Crime-Locator</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#app">Android-App</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">About</a>
                    </li>
                </ul>
                <form class="navbar-form navbar-right" action="#findCrimes" role="search">
                    <div class="form-group">
                        <input id="address" type="text" class="form-control" placeholder="Search for your town">
                    </div>
                    <button id="submit" type="button" class="btn btn-default"><i class="fa fa-search"></i></button>
                </form>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Intro Header -->
    <header class="intro">
        <div class="intro-body">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <p>
                            <img src="img/svg/logo.svg" class="brand-logo" width="35%" height="40%">
                            <h1 class="brand-heading">CrimeWatch</h1>
                            <a href="#features" class="btn btn-circle page-scroll">
                                <i class="fa fa-angle-double-down animated"></i>
                            </a>
                    </div>
                </div>
            </div>
        </div>
    </header>



    <!-- Feature Section -->
    <section id="features" class="container content-section text-center" style="padding-top: 100px;!important">

        <div class="row">
            </p>
            <p>
                Ever went out at night and thought: „Is this place safe?“
                <br> Ever wondered if your family-trip to that area was a good idea?
                <br> Ever thought about avoiding dangerous spots even before getting there?
                <br>

                <h3>CrimeWatch solves this issues!</h3>
                <br>
                <div class="col-lg-8 col-lg-offset-2">
                    <h3>Features:</h3>
                    <hr>
                    <ul class="list-unstyled">
                        <li>
                            <h5>watch your local crimes or inspect a location</h5></li>
                        <li>
                            <h5>get notified if you enter a dangerous area</h5></li>
                        <li>
                            <h5>simple usage &amp; access via web and app </h5></li>
                    </ul>
                </div>
        </div>
    </section>





    <!-- Map Section -->
    <section id="findCrimes" class="container content-section text-center">

        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <h2>Find Crimes:</h2>
            </div>
        </div>
    </section>
    <div id="map"></div>




    <!-- App Section -->
    <section id="app" class="content-section text-center">
        <div class="app-section">
            <div class="container">
                <div class="col-lg-8 col-lg-offset-2">
                    <table>
                        <tr>
                            <td>
                                <h2>Download CrimeWatch</h2>
                                <p>Get our app for free:</p>
                                <button href="#bar5" class="btn btn-default btn-lg" data-toggle="collapse" display="inline">Visit Download Page</button>
                                <div id="bar5" class="collapse">
                                    <img src="img/braintree.jpg" alt="TOO EASY TO BE TRUE" width="50%" height="50%">
                                </div>
                            </td>
                            <td>
                                <img src="img/app_screen1.png" alt="appscreen1" width="80%">
                            </td>
                            <td>
                                <img src="img/app_screen2.png" alt="appscreen2" width="80%">
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

    </section>






    <!-- Contact Section -->
    <section id="contact" class="container content-section text-center">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <h2>Contact us!</h2>
                <p>Feel free to give us feedback and ideas to improve the application!</p>

                <ul class="list-inline banner-social-buttons" style="display:inline;">
                    <div class="wrapteammember">
                        <li>
                            <figure>
                                <img class="teammember" src="img/chris.jpg" alt="dev1" width="30%" height="30%">
                                <figcaption><a href="https://github.com/wirebug" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Github</span></a>

                                    <p>
                                        <div class="donate-button">
                                            <button href="#bar1" class="btn btn-default btn-lg" data-toggle="collapse"><i class="fa fa-heart fa-fw"></i> <span class="network-name">Donate</span></button>
                                        </div>
                                        <div id="bar1" class="collapse">

                                            <p>
                                                <form id="checkout1" method="post" action="pay.php">
                                                    <div id="payment-form1"></div>
                                                    <input type="submit" value="Pay 10€">
                                                </form>

                                                <script src="https://js.braintreegateway.com/v2/braintree.js"></script>
                                                <script>
                                                    // We generated a client token for you so you can test out this code
                                                    // immediately. In a production-ready integration, you will need to
                                                    // generate a client token on your server (see section below).
                                                    var clientToken = "<?php echo Braintree_ClientToken::generate(); ?>";

                                                    braintree.setup(clientToken, "dropin", {
                                                        container: "payment-form1"
                                                    });

                                                </script>
                                            </p>
                                        </div>
                                    </p>
                                </figcaption>
                            </figure>
                        </li>
                    </div>

                    <div class="wrapteammember">
                        <li>
                            <figure>
                                <img class="teammember" src="img/silas.jpg" alt="dev1" width="30%" height="30%">
                                <figcaption><a href="https://github.com/simah002" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Github</span></a>

                                    <p>
                                        <div class="donate-button">
                                            <button href="#bar2" class="btn btn-default btn-lg" data-toggle="collapse"><i class="fa fa-heart fa-fw"></i> <span class="network-name">Donate</span></button>
                                        </div>
                                        <div id="bar2" class="collapse">

                                            <p>
                                                <form id="checkout2" method="post" action="pay.php">
                                                    <div id="payment-form2"></div>
                                                    <input type="submit" value="Pay 10€">
                                                </form>

                                                <script src="https://js.braintreegateway.com/v2/braintree.js"></script>
                                                <script>
                                                    // We generated a client token for you so you can test out this code
                                                    // immediately. In a production-ready integration, you will need to
                                                    // generate a client token on your server (see section below).
                                                    var clientToken = "<?php echo Braintree_ClientToken::generate(); ?>";

                                                    braintree.setup(clientToken, "dropin", {
                                                        container: "payment-form2"
                                                    });

                                                </script>
                                            </p>
                                        </div>
                                    </p>
                                </figcaption>
                            </figure>
                        </li>
                    </div>

                    <div class="wrapteammember">
                        <li>
                            <figure>
                                <img class="teammember" src="img/dev3.jpg" alt="dev1" width="30%" height="30%">
                                <figcaption><a href="https://github.com/spejss" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Github</span></a>

                                    <p>
                                        <div class="donate-button">
                                            <button href="#bar3" class="btn btn-default btn-lg" data-toggle="collapse"><i class="fa fa-heart fa-fw"></i> <span class="network-name">Donate</span></button>
                                        </div>
                                        <div id="bar3" class="collapse">

                                            <p>
                                                <form id="checkout3" method="post" action="pay.php">
                                                    <div id="payment-form3"></div>
                                                    <input type="submit" value="Pay 10€">
                                                </form>

                                                <script src="https://js.braintreegateway.com/v2/braintree.js"></script>
                                                <script>
                                                    // We generated a client token for you so you can test out this code
                                                    // immediately. In a production-ready integration, you will need to
                                                    // generate a client token on your server (see section below).
                                                    var clientToken = "<?php echo Braintree_ClientToken::generate(); ?>";

                                                    braintree.setup(clientToken, "dropin", {
                                                        container: "payment-form3"
                                                    });

                                                </script>
                                            </p>
                                        </div>
                                    </p>
                                </figcaption>
                            </figure>
                        </li>
                    </div>

                    <div class="wrapteammember">
                        <li>
                            <figure>
                                <img class="teammember" src="img/dev4.jpg" alt="dev1" width="30%" height="30%">
                                <figcaption><a href="https://github.com/skai92" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Github</span></a>

                                    <p>
                                        <div class="donate-button">
                                            <button href="#bar4" class="btn btn-default btn-lg" data-toggle="collapse"><i class="fa fa-heart fa-fw"></i> <span class="network-name">Donate</span></button>
                                        </div>
                                        <div id="bar4" class="collapse">

                                            <p>
                                                <form id="checkout4" method="post" action="pay.php">
                                                    <div id="payment-form4"></div>
                                                    <input type="submit" value="Pay 10€">
                                                </form>

                                                <script src="https://js.braintreegateway.com/v2/braintree.js"></script>
                                                <script>
                                                    // We generated a client token for you so you can test out this code
                                                    // immediately. In a production-ready integration, you will need to
                                                    // generate a client token on your server (see section below).
                                                    var clientToken = "<?php echo Braintree_ClientToken::generate(); ?>";

                                                    braintree.setup(clientToken, "dropin", {
                                                        container: "payment-form4"
                                                    });

                                                </script>
                                            </p>
                                        </div>
                                    </p>
                                </figcaption>
                            </figure>
                        </li>
                    </div>
                </ul>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer>
        <div class="container text-center">
            <h6>Copyright &copy; <br>by Christoph Weinzierl, Silas Mahler, Mikolaj Wawrzyniak, Kai Schr&ouml;er</h6>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="js/jquery.easing.min.js"></script>

    <!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCIC1fioMh3uSwSi9aWIfE3wNaPUwhhhCM&sensor=false"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/grayscale.js"></script>

</body>

</html>
