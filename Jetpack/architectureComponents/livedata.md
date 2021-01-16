### LiveData

1. 정의 및 특징

- LiveData는 주어진 수명주기 내에서 관찰 할 수있는 데이터 홀더 클래스
- LifecycleOwner가 활성 상태 인 경우에만 래핑 된 데이터의 수정에 대해 알림
- Lifecycle이 추가 된 관찰자는 해당 Lifecycle이 Lifecycle.State.DESTROYED상태로 이동하면 자동으로 제거
- LiveData에는 활성 개수가 0과 1 사이에서 변경 될 때 알림을받을 수있는 onActive()및 onInactive() 메서드가 Observer


