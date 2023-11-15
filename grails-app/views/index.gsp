<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
    <style>
        #controllers {
            margin-inline: auto;
            font-size:     1.2em; /* same as h2 height */
        }
        #controllers div {
            padding-left:   2em;
            letter-spacing: .1em;
        }
    </style>
</head>
<body>

<div id="content" role="main">
    <div class="container">
        <section class="row colset-2-its">
            <h1>Welcome to Room Bookings</h1>

            <div id="controllers" role="navigation">
                <h2>What you can see:</h2>

                <div>
                   <g:link controller="booking"> All Bookings </g:link>
                </div>
                <div>
                   <g:link controller="person"> All People </g:link>
                </div>
                <div>
                   <g:link controller="room"> All Rooms </g:link>
                </div>

            </div>
        </section>
    </div>
</div>

</body>
</html>
