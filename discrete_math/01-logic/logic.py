#define neg(), knj()

def neg(a):
    return int(not a)

def konj(a,b):
    return int(a and b)

def subj(a, b):
    if a==1 and b == 0:
        return 0
    else:
        return 1


# print WHT for neg, knj, equivalencies, tautology, widerspruchsbeweis.
print('Negation')
for x in 0, 1 :
    print(x, '|', neg(x))

print('\nKonjunktion')
for x in 0, 1 :
    for y in 0, 1:
        print(x, '|', y, '|', konj(x, y))

print('\nTautologie')
for x in 0, 1 :
    print(x, '|', int(x or neg(x)))

print('\nKontradiktion')
for x in 0, 1 :
    print(x, '|', int(x and neg(x)))

print('\nKommutativität - Konjunktion')
for x in 0, 1 :
    for y in 0, 1:
        print(x, '|', y, '|', int(x and y), '|', int(y and x))

print('\nKommutativität - Disjunktion')
for x in 0, 1 :
    for y in 0, 1:
        print(x, '|', y, '|', int(x or y), '|', int(y or x))

print('\nAssoziativität - Konjunktion')
for x in 0, 1 :
    for y in 0, 1:
        for z in 0,1:
            print(x, '|', y, '|', z, '|', int((x and y) and z), '|', int((y and z) and x))

print('\nAssoziativität - Disjunktion')
for x in 0, 1 :
    for y in 0, 1:
        for z in 0,1:
            print(x, '|', y, '|', z, '|', int((x or y) or z), '|', int((y or z) or x))

print('\nDe Morgan 1')
for x in 0, 1 :
    for y in 0, 1:
        print(x, '|', y, '|', int(x and y), '|', int(neg(y) or neg(x)))

print('\nDe Morgan 2')
for x in 0, 1 :
    for y in 0, 1:
        print(x, '|', y, '|', int(x or y), '|', int(neg(y) and neg(x)))

print('\nWiderspruchsbeweis Beispiel')
print('P1:= P => ¬S')
print('P2:= P => (¬S => B)')
print('¬K:= P => B')
print('T:= ¬K ^ P1 ^ P2  (Test auf Sinnschluss)')
print("x | y | z | P1| P2| ¬K| T")
for x in 0, 1 :
    for y in 0, 1:
        for z in 0, 1:
            print(x, '|', y, '|', z, '|', int(subj(x, neg(y))), '|',
                  int(subj(x,subj(neg(y),z))), '|',
                  int(subj(x,z)), '|',
                  int(subj(x, neg(y)) and subj(x,subj(neg(y),z)) and subj(x,z)))


