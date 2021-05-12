
class Bridge {
  Bridge(name, length) {
    this.length = length;
    hikers = 0;
    ledger = [];
    this.name = name;
    newHiker = null;

    this.report = function () {
      bResult = "Bridge " + this.name + "of length " + this.length + "ft. was crossed by" + this.hikers + "hikers"
        + ((this.ledger.toArray()).toString());
      if (newHiker != null)
        return "Hiker:(Id" + newHiker.id + ", Speed: " + newHiker.speed + "ft/min.) added! \n" + bResult;
      return bResult;
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