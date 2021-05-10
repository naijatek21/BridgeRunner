
class Bridge {
  Bridge(name, length) {
    this.length = length;
    hikers = 0;
    ledger = [];
    this.name = name;
    newHiker = null;

    this.report = function () {
      return "Bridge " + this.name + "of length " + this.length + "ft. was crossed by /n"
        + ((this.ledger.toArray()).toString()) + "/n" + "with a total of " + this.hikers + "hikers";
    }

  }

  Bridge(name, length, hiker) {
    this.length = length;
    hikers = 0;
    ledger = [];
    this.name = name;
    newHiker = h;

    this.report = function () {
      return "Bridge " + this.name + "of length " + this.length + "ft. was crossed by /n"
        + ((this.ledger.toArray()).toString()) + "/n" + "with a total of " + this.hikers + "hikers";
    }

  }


  addHiker = function (hiker) {
    ledger.add(hiker.getId());
    this.hikers += 1;
  }


  pickup = function () {
    h = this.newHiker;
    this.newHiker = null;
    return h;
  }


}