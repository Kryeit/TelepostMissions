# Telepost Missions

See:
- [Telepost](https://github.com/Kryeit/Telepost)
- [Create: Missions](https://github.com/Kryeit/Missions)

Both are dependencies for this mod.

## Versions
- Fabric 1.20.1

The rest of the dependencies are likely to be compatible with different versions of the Telepost and Missions mod.

## Installation
1. Add the Telepost, Create: Missions and Create Fabric.
2. Add this mod.
3. Modify `config/missions/missions.json` and add:

<details>
  <summary>Telepost Missions configuration</summary>

  ```json
{
  "invite": {
    "reward": {
      "amount": "2-23",
      "item": "diamond"
    },
    "missions": {
      "missions:invites": "4-6"
    },
    "titles": [
      "TTT",
      "Hide your valuables",
      "The beggining of a new friendship"
    ]
  },
  "invited": {
    "reward": {
      "amount": "2-23",
      "item": "diamond"
    },
    "missions": {
      "missions:invites": "4-6"
    },
    "titles": [
      "Let them trust you",
      "There cannot be that many posts"
    ]
  }
```
</details>

4. Run the server




