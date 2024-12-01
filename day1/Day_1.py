from collections import Counter

def line_to_int_pair(line: str) -> tuple[int, int]:
    parts = line.split()
    assert len(parts) == 2
    return (int(parts[0]), int(parts[1]))

with open("input.txt", "r") as f:
    lines = f.readlines()

pairs: list[tuple[int, int]] = list(map(line_to_int_pair, lines))
a = sorted([x[0] for x in pairs])
b = sorted([x[1] for x in pairs])

total_distance = sum([abs(x - y) for x, y in zip(a, b)])
print(total_distance)

b_freq = Counter(b)
similarity_score = sum([x * b_freq[x] for x in a])
print(similarity_score)