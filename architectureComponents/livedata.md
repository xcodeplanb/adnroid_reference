### LiveData

1. 정의 및 특징

- LiveData는 주어진 수명주기 내에서 관찰 할 수있는 데이터 홀더 클래스입니다.
  즉 Observer,는와 쌍으로 추가 LifecycleOwner될 수 있으며이 관찰자는 쌍을 이루는 LifecycleOwner가 활성 상태 인 경우에만 래핑 된 데이터의 수정에 대해 알림을받습니다.
  LifecycleOwner는 상태가 Lifecycle.State.STARTED또는 인 경우 활성으로 간주됩니다.
  Lifecycle.State.RESUMED. 을 통해 추가 된 관찰자 observeForever(Observer)는 항상 활성 상태로 간주되므로 항상 수정에 대해 알림을받습니다.
  이러한 관찰자의 경우 수동으로 removeObserver(Observer).
  Lifecycle이 추가 된 관찰자는 해당 Lifecycle이 Lifecycle.State.DESTROYED상태로 이동하면 자동으로 제거됩니다.
  이것은 LiveData를 안전하게 관찰 할 수 있고 누수에 대해 걱정할 수없는 활동 및 조각에 특히 유용합니다. 파괴되면 즉시 구독이 취소됩니다.
  또한 LiveData에는 활성 개수가 0과 1 사이에서 변경 될 때 알림을받을 수있는 onActive()및 onInactive()메서드가 Observer있습니다.
  이를 통해 LiveData는 적극적으로 관찰중인 Observer가 없을 때 무거운 리소스를 해제 할 수 있습니다.


