# How to send an SMS in Python using Twillo

from twilio.rest import Client
import keys

client = Client(keys.account_sid, keys.auth_token)

message = client.messages.create(
    body = "are you ok?",
    from_= '+13609970543',
    to=keys.my_number
)

print(message.body)