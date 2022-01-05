import re
import random
from math import ceil


def reply_percentage(message, message_requirement, important):
    count = 0
    for i in message:
        if i in message_requirement:
            count += 1
        if i in important:
            count = len(message)


    percentage = 0
    if count != 0:
        percentage = float(count)/float(len(message))


    return percentage*100


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
    bot.append(['seen','ok ok'])  # 5

    unknown = ['Sorry, I\'m a bot, I dont understad', 'ano besh?', 'di ko gets, pakilinaw']
    bot_int = []

    bot_int.append(reply_percentage(input_message, ['hi', 'hello'],['']))
    bot_int.append(reply_percentage(input_message, ['kumusta', 'balita'],['kumusta','balita']))
    bot_int.append(reply_percentage(input_message, ['kumain','kain'],['']))
    bot_int.append(reply_percentage(input_message, ['gawa', 'ginagawa'],['']))
    bot_int.append(reply_percentage(input_message, ['ilan', 'taon'],['']))
    bot_int.append(reply_percentage(input_message, ['okay', 'k', 'ok'],['']))

    max = get_max(bot_int)


    if max == 0:
        reply=unknown[random.randint(0, len(unknown)-1)]
    else:
        index = bot_int.index(max)

        rand = random.randint(0, len(bot[index])-1)
        reply = bot[index][rand]

    return reply


def get_response(input_message):
    split_message = re.split(r"[-;,.\s]\s*", input_message)
    return generate_response(split_message)


while True:
    print('Bot: ' + get_response(input('You: ')))
