import random

def generate_card_list(n):
    card_list = []
    card_names = ['As', 'Valete', 'Dama', 'Rei'] + [str(i) for i in range(2, 11)]
    card_suits = ['Copas', 'Espadas', 'Ouros', 'Paus']

    for a in range(n):
        if random.randint(0, 52) == 0:
            card_list.append('Curinga')
        else:
            card_list.append(random.choice(card_names) + ' de ' + random.choice(card_suits))
    
    return card_list

if __name__ == '__main__':
    card_list = generate_card_list(100)
    

    with open('cartas.txt', 'w') as f:
        for a in card_list:
            f.write(a + '\n')