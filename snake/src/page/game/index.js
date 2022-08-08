import {useEffect, useRef, useState} from "react";

const MainFrame = () => {

  const direc = {
    up: [0, -1],
    down: [0, 1],
    left: [-1, 0],
    right: [1, 0]
  }

  const [actor, setActor] = useState({
    snake: [[4, 1], [3, 1], [2, 1]],
    apple: [10, 10],
    score: 0,
    dir: 'right'
  })
  const canvas = useRef()
  const ref = useRef()
  const [time, setTime] = useState(600)
  const [begin, setBegin] = useState(false)
  const [timer, setTimer] = useState(-1)

  useEffect(() => {
    if (begin) {
      setTimer(setInterval(run, time))
      canvas.current.focus();
    } else {
      clearInterval(timer)
    }
  }, [begin])

  const changeDir = event => {
    const {code} = event
    switch (code) {
      case 'ArrowLeft':
      case 'KeyA': {
        if (actor.dir !== 'right') {
          setActor({...actor, dir: 'left'})
        }
        break
      }
      case 'ArrowRight':
      case 'KeyD' : {
        if (actor.dir !== 'left') {
          setActor({...actor, dir: 'right'})
        }
        break
      }
      case 'ArrowUp':
      case 'KeyW' : {
        if (actor.dir !== 'down') {
          setActor({...actor, dir: 'up'})
        }
        break
      }
      case 'ArrowDown':
      case 'KeyS' : {
        if (actor.dir !== 'up') {
          setActor({...actor, dir: 'down'})
        }
        break
      }
      case 'Space': {
        setBegin(!begin)
        break
      }
      default : {
        break
      }
    }
    console.log(actor.dir)
  }

  useEffect(() => {
    window.addEventListener('keydown', changeDir, true)
  }, [])

  const run = () => {
    setActor(actor => {
      let {snake, apple, score, dir} = actor
      const [dx, dy] = direc[dir]
      const [x, y] = snake[0];
      const head = [x + dx, y + dy]
      snake.unshift(head)
      const eat = head[0] === apple[0] && head[1] === apple[1]
      if (!eat) {
        snake.pop();
      } else {
        score++;
        do {
          apple = [Math.floor(Math.random() * 20), Math.floor(Math.random() * 20)];
        } while (snake.some(node => node[0] === apple[0] && node[1] === apple[1]))
      }

      return {snake, apple, score, dir};
    })
  }


  useEffect(() => {
    const ctx = canvas.current.getContext('2d');
    ctx.fillStyle = 'pink'
    ctx.strokeRect(0, 0, 420, 420)
    ctx.fillRect(10, 10, 400, 400);
    ctx.fillStyle = 'blue'
    actor.snake.forEach(node => {
        const [x, y] = node
        ctx.fillRect(10 + 20 * x, 10 + 20 * y, 20, 20)
      }
    )
    ctx.fillStyle = 'red'
    ctx.fillRect(10 + 20 * actor.apple[0], 10 + 20 * actor.apple[1], 20, 20)

  }, [actor])

  return (
    <div>
      <div>
        <canvas ref={canvas} width={'420px'} height={'420px'}/>
      </div>
      <div>
        <button onClick={() => {
          setBegin(!begin)
        }}>{begin ? '暂停' : '开始'}</button>
        <span>{actor.score}</span>
        <input type={"text"} ref={ref}/>
        <button onClick={() => setTime(Number.parseInt(ref.current.value))}>改变时间间隔</button>
      </div>
    </div>
  );
}

export default MainFrame