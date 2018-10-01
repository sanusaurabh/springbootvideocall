var ws = new WebSocket('wss://' + location.host + '/call');

function register() {

    var name = document.getElementById('email_id').value = document.getElementById('email_id').innerHTML;//document.getElementById('email_id').value;
    if (name == '') {
        window.alert('You must insert your user name');
        document.getElementById('name').focus();
        return;
    }
   // setRegisterState(REGISTERING);

    var message = {
        id : 'register',
        name : name
    };
    sendMessage(message);
}

function sendMessage(message) {
    var jsonMessage = JSON.stringify(message);
    console.log('Senging message: ' + jsonMessage);
    ws.send(jsonMessage);
}

ws.onmessage = function(message) {
    var parsedMessage = JSON.parse(message.data);
    console.info('Received message: ' + message.data);

    switch (parsedMessage.id) {
        case 'resgisterResponse':
            alert(parsedMessage.response);
            resgisterResponse(parsedMessage);
            break;
        default:
            console.error('Unrecognized message', parsedMessage);
    }
}