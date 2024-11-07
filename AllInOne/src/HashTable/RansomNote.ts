function canConstruct(ransomNote: string, magazine: string): boolean {
  const map: number[] = new Array(26).fill(0);

  for (let c of magazine) {
    map[c.charCodeAt(0) - 'a'.charCodeAt(0)]++;
  }

  for (let c of ransomNote) {
    if (--map[c.charCodeAt(0) - 'a'.charCodeAt(0)] < 0) {
      return false;
    }
  }

  return true;
}

// method 2
function canConstruct2(ransomNote: string, magazine: string): boolean {
  // const map: number[] = new Array(26).fill(0)

  // for (let c of magazine) {
  //     map[c.charCodeAt(0) - 'a'.charCodeAt(0)] ++
  // }

  // for (let c of ransomNote) {
  //     if (-- map[c.charCodeAt(0) - 'a'.charCodeAt(0)] < 0) {
  //         return false
  //     }
  // }

  // return true
  const map = new Map<string, number>();

  for (const letter of magazine) {
    map.set(letter, !map.has(letter) ? 1 : map.get(letter)! + 1);
  }

  for (const letter of ransomNote) {
    if (map.get(letter)) {
      map.set(letter, map.get(letter)! - 1);
    } else {
      return false;
    }
  }

  return true;
}
