import re
import random


def reply_percentage(message, message_requirement):
    count = 0
    for i in message:
        if i in message_requirement:
            count += 1

    percentage = 0
    if count != 0:
        percentage = float(count)/float(len(message))

    return int(percentage)*100


def get_max(arr):
    max = arr[0]
    for i in range(len(arr)):
        if(arr[i]>max):
            max = arr[i]
    return max


def generate_response(input_message):
    bot = []

    bot.append(['hi', 'hello'])#1
    bot.append(['okay lang', 'eto tambay', 'eto buhay pa hehe'])#2
    bot.append(['tapos na ko', 'busog pa'])#3
    bot.append(['nagcocode', 'wala pahinga ', 'eto nagfefacebook'])#4
    bot.append(['1 day old'])#5

    unknown = ['Sorry, I\'m a bot, I dont understad', 'ano besh?', 'di ko gets, pakilinaw']
    bot_int = []

    bot_int.append(reply_percentage(input_message, ['hi', 'hello']))
    bot_int.append(reply_percentage(input_message, ['kumusta', 'balita', 'ka', 'na']))
    bot_int.append(reply_percentage(input_message, ['kumain','kain','ka', 'na']))
    bot_int.append(reply_percentage(input_message, ['gawa', 'ginagawa']))
    bot_int.append(reply_percentage(input_message, ['ilan', 'taon']))

    max = get_max(bot_int)

    if max == 0:
        reply=unknown[random.randint(0, len(unknown)-1)]
    else:
        index = bot_int.index(max)
        print(max)
        rand = random.randint(0, len(bot[index])-1)
        reply = bot[index][rand]

    return reply


def get_response(input_message):
    split_message = re.split(r"[-;,.\s]\s*", input_message)
    return generate_response(split_message)


while True:
    print('Bot: ' + get_response(input('You: ')))
